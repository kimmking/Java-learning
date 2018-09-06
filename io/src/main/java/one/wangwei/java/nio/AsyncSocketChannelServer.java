package one.wangwei.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AsyncSocketChannelServer {

    public static final int BUFFER_SIZE = 768;

    private static final Logger logger = Logger.getLogger("Proxy");

    private static abstract class Handler<A> implements CompletionHandler<Integer, A> {
        @Override
        public void failed(Throwable exc, A attachment) {
            error(exc, attachment);
        }
    }

    private static void error(Throwable exc, Object attachment) {
        logger.log(Level.WARNING, "IO failure in " + attachment, exc);
    }

    private static Queue<ByteBuffer> queue = new ConcurrentLinkedQueue<>();

    private static ByteBuffer getBuffer() {
        ByteBuffer poll = queue.poll();
        if (poll == null) {
            return ByteBuffer.allocate(BUFFER_SIZE);
        }
        return poll;
    }

    private static AtomicLong count = new AtomicLong(0);

    private static volatile long startTime;

    private static void read(final AsynchronousSocketChannel reader, AsynchronousSocketChannel writer) {
        final ByteBuffer buffer = getBuffer();
        reader.read(buffer, writer, new Handler<AsynchronousSocketChannel>() {
            @Override
            public void completed(Integer result, final AsynchronousSocketChannel writer) {
                if (result == -1) {
                    return;
                }
                //System.err.println(Thread.currentThread().getName() + " READ " + result);

                long count = AsyncSocketChannelServer.count.addAndGet(result);
                long nanoTime = System.nanoTime();
                if (nanoTime - startTime > 5000000000L) {
                    System.out.format("%3.2f MiB/s%n", count * 1000000000L / (double) (nanoTime - startTime) / 1048576.0);
                    if (AsyncSocketChannelServer.count.compareAndSet(count, 0)) {
                        startTime = nanoTime;
                    }
                }
                writer.write((ByteBuffer) buffer.flip(), buffer, new Handler<ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        //System.err.println(Thread.currentThread().getName() + " WROTE: " + result);
                        if (attachment.hasRemaining()) {
                            writer.write(attachment, attachment, this);
                        } else {
                            queue.add((ByteBuffer) attachment.clear());
                        }
                    }
                });

                read(reader, writer);
            }
        });
    }

    private static AsynchronousChannelGroup newACG() throws IOException {
        return AsynchronousChannelGroup.withThreadPool(
                Executors.unconfigurableExecutorService(Executors.newFixedThreadPool(1)));
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8080;
        CountDownLatch done = new CountDownLatch(1);

        if (args.length > 0 && args[0].equals("-c")) {
            final AsynchronousSocketChannel client;
            try {
                client = AsynchronousSocketChannel.open(newACG());
                client.connect(new InetSocketAddress("localhost", port)).get();
            } catch (Exception e) {
                error(e, "connect failed: " + port);
                System.exit(1);
                return;
            }

            read(client, client);

            final ByteBuffer writeBuffer = getBuffer();
            client.write(writeBuffer, "write", new CompletionHandler<Integer, String>() {
                @Override
                public void completed(Integer result, String attachment) {
                    startTime = System.nanoTime();
                    System.err.println(Thread.currentThread().getName() + " WROTE INITIAL " + result);
                    queue.offer(writeBuffer);
                }

                @Override
                public void failed(Throwable exc, String attachment) {
                    error(exc, attachment);
                    System.exit(1);
                }
            });


        } else {
            final AsynchronousServerSocketChannel listener =
                    AsynchronousServerSocketChannel.open(newACG()).bind(new InetSocketAddress(port));

            listener.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
                @Override
                public void completed(final AsynchronousSocketChannel client, Void att) {
                    // accept the next connection
                    listener.accept(null, this);
                    read(client, client);

//          final ByteBuffer writeBuffer = getBuffer();
//          client.write(writeBuffer, "write", new CompletionHandler<Integer, String>() {
//            @Override
//            public void completed(Integer result, String attachment) {
//              startTime = System.nanoTime();
//              //System.err.println(Thread.currentThread().getName() + "WROTE INITIAL " + result);
//              queue.offer(writeBuffer);
//            }
//
//            @Override
//            public void failed(Throwable exc, String attachment) {
//              error(exc, attachment);
//              System.exit(1);
//            }
//          });
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    error(exc, "accept");
                    System.exit(1);
                }
            });
        }

        done.await();
    }
}
package one.wangwei.java.nio;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SocketChannelEchoServer {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 8900));
        serverSocket.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer byteBuffer = ByteBuffer.allocate(256);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    register(selector, serverSocket);
                }

                if (selectionKey.isReadable()) {
                    answerWithEcho(byteBuffer, selectionKey);
                }
                iterator.remove();
            }
        }
    }

    private static void register(Selector selector, ServerSocketChannel socketChannel) throws IOException {
        SocketChannel client = socketChannel.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

    private static void answerWithEcho(ByteBuffer buffer, SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        client.read(buffer);
        buffer.flip();
        client.write(buffer);
        buffer.clear();
    }

    public static Process start() throws IOException {
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String classpath = System.getProperty("java.class.path");
        String className = SocketChannelEchoServer.class.getCanonicalName();
        ProcessBuilder processBuilder = new ProcessBuilder(javaBin, "-cp", classpath, className);
        return processBuilder.start();
    }

}

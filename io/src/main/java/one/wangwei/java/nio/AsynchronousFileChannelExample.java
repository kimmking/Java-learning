package one.wangwei.java.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AsynchronousFileChannelExample {

    public static void main(String[] args) {
        try {
            Path path = Paths.get("/Users/wangwei/Desktop/test.txt");
            AsynchronousFileChannel fileChannel =
                    AsynchronousFileChannel.open(path, StandardOpenOption.READ);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.read(buffer, 0, buffer,
                    new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            System.out.println(result);
                            System.out.println(new String(attachment.array()));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {

                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

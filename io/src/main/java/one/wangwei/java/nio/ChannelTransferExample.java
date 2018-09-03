package one.wangwei.java.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTransferExample {

    public static void main(String[] args) {
        try {
            RandomAccessFile fromFile = new RandomAccessFile("/Users/wangwei/Desktop/fromFile.txt", "rw");
            FileChannel fromChannel = fromFile.getChannel();

            // create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);

            // read data from channel into buffer
            int bytesRead = fromChannel.read(buf);
            while (bytesRead != -1) {

                // switch to read mode
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.println((char) buf.get());
                }

                // make buffer ready for writing
                buf.clear();
                bytesRead = fromChannel.read(buf);
            }

            fromChannel.close();
            fromFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

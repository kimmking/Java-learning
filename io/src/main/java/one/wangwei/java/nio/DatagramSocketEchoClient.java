package one.wangwei.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramSocketEchoClient {

    public static void main(String[] args) {
        try {
            DatagramChannel client = DatagramChannel.open();
            client.bind(null);

            String msg = "hello";
            ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
            InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 8989);

            client.send(buffer, serverAddress);
            buffer.clear();
            client.receive(buffer);
            buffer.flip();

            int limits = buffer.limit();
            byte[] bytes = new byte[limits];
            buffer.get(bytes, 0, limits);
            String response = new String(bytes);
            System.out.println("Server response: " + response);
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

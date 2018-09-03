package one.wangwei.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class DatagramSocketEchoServer {

    public static void main(String[] args) {
        try {
            DatagramChannel server = DatagramChannel.open();
            InetSocketAddress sAddr = new InetSocketAddress("127.0.0.1", 8989);
            server.bind(sAddr);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            while (true) {
                System.out.println("Waiting for a message from a remote host at " + sAddr);
                SocketAddress remoteAddr = server.receive(byteBuffer);
                byteBuffer.flip();
                int limits = byteBuffer.limit();
                byte[] bytess = new byte[limits];
                byteBuffer.get(bytess, 0, limits);
                String msg = new String(bytess);

                System.out.println("Client at " + remoteAddr + " says: " + msg);
                byteBuffer.rewind();
                server.send(byteBuffer, remoteAddr);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package one.wangwei.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class EchoClient {

    private static SocketChannel client;
    private static ByteBuffer buffer;
    private static EchoClient instance;

    private EchoClient() {
        try {
            client = SocketChannel.open();
            client.configureBlocking(false);
            client.connect(new InetSocketAddress("127.0.0.1", 8900));
            buffer = ByteBuffer.allocate(256);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EchoClient start() {
        if (instance == null) {
            instance = new EchoClient();
        }
        return instance;
    }

    public static void stop() throws IOException {
        buffer = null;
        client.close();
    }

    public String sendMessage(String msg) {
        buffer = ByteBuffer.wrap(msg.getBytes());
        String response = null;
        try {
            client.write(buffer);
            buffer.clear();
            client.read(buffer);
            response = new String(buffer.array()).trim();
            System.out.println("response=" + response);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


    public static void main(String[] args) {
        EchoClient client = EchoClient.start();
        System.out.println("Enter your message:");
        Scanner scanner = new Scanner(System.in);
        client.sendMessage(scanner.nextLine());
    }
}

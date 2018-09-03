package one.wangwei.java;

import org.junit.Test;

import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
        while (enumeration.hasMoreElements()) {
            NetworkInterface nif = enumeration.nextElement();
            System.out.println("Name: " + nif.getName()
                    + ",  Supports Multicast: " + nif.supportsMulticast()
                    + ", isUp(): " + nif.isUp());
        }
    }
}

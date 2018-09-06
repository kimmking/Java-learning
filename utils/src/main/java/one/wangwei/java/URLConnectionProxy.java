package one.wangwei.java;

import com.google.common.net.InetAddresses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Random;

public class URLConnectionProxy {

    /**
     * The User Agent
     */
    private static final String AGENT = "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)";

    /**
     * Used to store the proxy settings
     */
    private Proxy proxy;

    /**
     * Method used to add proxy settings
     *
     * @param ip   the proxy IP
     * @param port the proxy port
     */
    public void setProxy(String ip, int port) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
    }

    /**
     * Method used to add proxy settings with authentication
     *
     * @param ip
     * @param port
     * @param username
     * @param password
     */
    public void setProxy(String ip, int port, final String username, final String password) {
        this.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
        Authenticator authenticator = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return (new PasswordAuthentication(username, password.toCharArray()));
            }
        };
        Authenticator.setDefault(authenticator);

    }

    /**
     * The method will return the content in a {@link InputStream} object
     *
     * @param domain The Domain name
     * @return the content as {@link InputStream} object
     * @throws Exception
     */
    private InputStream getContent(String domain) throws Exception {
        URL url = new URL(domain);
        URLConnection connection = null;
        if (this.proxy != null)
            connection = url.openConnection(this.proxy);
        else
            connection = url.openConnection();
        connection.setRequestProperty("User-Agent", AGENT);
        return connection.getInputStream();
    }

    /**
     * Method used to get URL content in {@link String} format
     *
     * @param domain the {@link String} the URL
     * @return the {@link String} object returned
     * @throws Exception
     */
    public String getString(String domain) throws Exception {
        InputStream is = getContent(domain);
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /** finally block to close the {@link BufferedReader} */
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("URLConnection with Proxy Example");
        System.out.println();
        String url = "https://wangwei.one/posts/f409841b.html";
        URLConnectionProxy con = new URLConnectionProxy();
        /**
         * activate this line if you are behind a proxy server - change the settings
         * accordingly
         */
        Random random = new Random();
        String address = InetAddresses.fromInteger(random.nextInt()).getHostAddress();
        System.out.println("address=" + address);
        con.setProxy("183.88.57.228", 80);
        /**
         * activate this line if you are behind a proxy server with authentication -
         * change the settings accordingly
         */
        String result = con.getString(url);

        System.out.println("URL: " + url);
        System.out.println();
        System.out.println(result);
    }
}
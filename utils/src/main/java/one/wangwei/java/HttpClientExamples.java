package one.wangwei.java;

import com.google.common.collect.Maps;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.Executors;

public class HttpClientExamples {

    private final static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36";

    public static void main(String[] args) {

        Map<String, Integer> map = Maps.newHashMap();
        map.put("https://wangwei.one/posts/build-blockchain-in-java-transaction-utxo.html", 4528);
        map.put("https://wangwei.one/posts/build-blockchain-in-java-wallet-address.html", 1000);
        map.put("https://wangwei.one/posts/build-blockchain-in-java-transaction-merkle-tree.html", 5183);
        map.put("https://wangwei.one/posts/build-blockchain-in-java-transaction-script.html", 4394);
        map.put("https://wangwei.one/posts/java-11-base-tutorial.html", 214);
        map.put("https://wangwei.one/posts/netty-channel-intro.html", 598);
        map.put("https://wangwei.one/posts/netty-core-assembly-intro.html", 1931);
        map.put("https://wangwei.one/posts/netty-base-theory-intro.html", 2098);
        map.put("https://wangwei.one/posts/5-unix-io-model-intro.html", 2673);
        map.put("https://wangwei.one/posts/server-thread-io-model-reactor-proactor.html", 863);

        for (final Map.Entry<String, Integer> entry : map.entrySet()) {
            Executors.newFixedThreadPool(100).submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            incBlogVister(entry.getKey(), entry.getValue());
                        }
                    });
        }
    }

    private static void incBlogVister(final String referer, final int pv) {
        for (int i = 0; i <= pv; i++) {
            System.out.println("i=" + i + ", referer=" + referer);
            try {
                String url = "https://busuanzi.ibruce.info/busuanzi?jsonpCallback=BusuanziCallback_922063302095";
                String proxyIp = "24.106.221.230";
                int proxyPort = 53281;

                HttpHost proxy = new HttpHost(proxyIp, proxyPort);
                HttpClient client = HttpClientBuilder.create().build();
                HttpGet request = new HttpGet(url);

                // add request header
                request.addHeader("User-Agent", USER_AGENT);
                request.addHeader("Referer", referer);
                HttpResponse response = client.execute(request);

                System.out.println("Response Code : "
                        + response.getStatusLine().getStatusCode());

                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

                StringBuffer result = new StringBuffer();
                String line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

                System.out.println(result.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

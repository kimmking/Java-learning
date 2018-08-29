package one.wangwei.java.concurrent.thread;

/**
 * Created by wangwei on 16/2/19.
 */
public class ThreadA extends Thread {

    public void run() {
        super.run();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }
}

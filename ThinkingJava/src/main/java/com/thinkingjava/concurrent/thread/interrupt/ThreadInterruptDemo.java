package com.thinkingjava.concurrent.thread.interrupt;

/**
 * Created by wangwei on 16/2/25.
 */
public class ThreadInterruptDemo implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        boolean stop = false;
        while (!stop) {
            System.out.println("My Thread is running......");
            long time = System.currentTimeMillis();
//            while ((System.currentTimeMillis() - time) < 1000) {
//
//            }
//            if (Thread.currentThread().isInterrupted()) {//判断当前线程是否中断
//                break;
//            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
//                e.printStackTrace();
                break;
            }
        }
        System.out.println("My Thread existing under request.....");
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new ThreadInterruptDemo(), "InterruptDemo Thread");
        System.out.println("Starting thread.....");
        thread.start();
        Thread.sleep(3000);
        thread.interrupt(); // 主线程中断子线程thread
        System.out.println("线程是否中断：" + thread.isInterrupted());
        Thread.sleep(3000);
        System.out.println("Stopping application......");
    }


}

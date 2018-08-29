/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package one.wangwei.java.concurrent.thread.queue;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wangwei on 16/3/25.
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        try {
            CountDownLatch countDownLatch = new CountDownLatch(3);
            Worker worker1 = new Worker("程序猿1", countDownLatch);
            Worker worker2 = new Worker("程序猿2", countDownLatch);
//            Worker worker3 = new Worker("程序猿3", countDownLatch);
//            Worker worker4 = new Worker("程序猿4", countDownLatch);
            worker1.start();
            worker2.start();
//            worker3.start();
//            worker4.start();
            countDownLatch.await();
            System.out.println("Main thread end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Worker extends Thread {
        private String workerName;
        private CountDownLatch countDownLatch;

        public Worker(String workerName, CountDownLatch countDownLatch) {
            this.workerName = workerName;
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            try {
                System.out.println("Worker:" + workerName + " is begin!");
                Thread.sleep(1000);
                System.out.println("Worker:" + workerName + " is end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }

    }

}

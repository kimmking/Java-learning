/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.thinkingjava.concurrent.thread.threadlocal;

/**
 * Created by wangwei on 16/3/2.
 */
public class ThreadLocalMain {

    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    public ThreadLocal<Integer> getThreadLocal() {
        return seqNum;
    }

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }


    public static void main(String[] args) {
        ThreadLocalMain threadLocalMain = new ThreadLocalMain();

        TestClient client1 = new TestClient(threadLocalMain);
        TestClient client2 = new TestClient(threadLocalMain);
        TestClient client3 = new TestClient(threadLocalMain);

        client1.start();
        client2.start();
        client3.start();
    }


    private static class TestClient extends Thread {
        private ThreadLocalMain sn;

        public TestClient(ThreadLocalMain sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "] ---> sn [" + sn.getNextNum() + "]");
            }
            sn.getThreadLocal().remove();
        }
    }
}

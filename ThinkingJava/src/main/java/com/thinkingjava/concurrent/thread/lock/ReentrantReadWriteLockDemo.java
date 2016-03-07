/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.thinkingjava.concurrent.thread.lock;

/**
 * Created by wangwei on 16/3/7.
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        final Count2 count = new Count2();

        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    count.put();
                }
            }.start();
        }
    }

    // 读锁不互斥、写锁互斥

}

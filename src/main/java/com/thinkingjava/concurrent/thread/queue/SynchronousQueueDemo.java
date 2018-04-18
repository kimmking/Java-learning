/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.thinkingjava.concurrent.thread.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * Created by wangwei on 16/3/16.
 */
public class SynchronousQueueDemo {
    public static void main(String args[]) {
        final SynchronousQueue<String> queue = new SynchronousQueue<String>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String event = "FOUR";
                try {
                    queue.put(event); // thread will block here
                    System.out.printf("[%s] published event : %s %n", Thread.currentThread().getName(), event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "PRODUCER").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String event = queue.take(); // thread will block here
                    System.out.printf("[%s] consumed event : %s %n", Thread.currentThread().getName(), event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CONSUMER").start();
    }

}

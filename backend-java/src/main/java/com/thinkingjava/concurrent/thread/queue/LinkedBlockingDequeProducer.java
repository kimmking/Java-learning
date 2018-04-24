/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.thinkingjava.concurrent.thread.queue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingDeque;

/**
 * Created by wangwei on 16/3/24.
 */
public class LinkedBlockingDequeProducer implements Runnable {

    protected BlockingDeque<String> blockingDeque;
    final Random random = new Random();

    public LinkedBlockingDequeProducer(BlockingDeque<String> queue) {
        this.blockingDeque = queue;
    }

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
        try {
            String data = UUID.randomUUID().toString();
            System.out.println("Put: " + data);
            blockingDeque.addFirst(data);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

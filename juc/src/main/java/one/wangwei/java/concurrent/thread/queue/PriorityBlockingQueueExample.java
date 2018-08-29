/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package one.wangwei.java.concurrent.thread.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wangwei on 16/3/14.
 */
public class PriorityBlockingQueueExample {

    public static void main(String[] args) {

        final BlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();

    }
}

class Producer implements Runnable {
    BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                queue.put(ThreadLocalRandom.current().nextInt(0, 1000));
            } catch (Exception e) {
            }
        }
    }
}

class Consumer implements Runnable {
    BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(queue.take());
            } catch (Exception e) {
            }
        }
    }
}

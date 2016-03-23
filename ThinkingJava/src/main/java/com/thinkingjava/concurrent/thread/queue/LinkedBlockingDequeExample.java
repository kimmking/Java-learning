/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.thinkingjava.concurrent.thread.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wangwei on 16/3/24.
 */
public class LinkedBlockingDequeExample {
    public static void main(String[] args) {
        final BlockingDeque<String> priorityBlockingQueue = new LinkedBlockingDeque<String>();

        LinkedBlockingDequeProducer queueProducer = new LinkedBlockingDequeProducer(
                priorityBlockingQueue);
        new Thread(queueProducer).start();

        LinkedBlockingDequeConsumer queueConsumer1 = new LinkedBlockingDequeConsumer(
                priorityBlockingQueue);
        new Thread(queueConsumer1).start();

        LinkedBlockingDequeConsumer queueConsumer2 = new LinkedBlockingDequeConsumer(
                priorityBlockingQueue);
        new Thread(queueConsumer2).start();
    }
}

/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package one.wangwei.java.concurrent.thread.queue;

import java.util.concurrent.DelayQueue;

/**
 * Created by wangwei on 16/3/16.
 */
public class DelayQueueDemo {

    public static void main(String[] args) {

        final DelayQueue<Student> dq = new DelayQueue<Student>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student("学生" + i, Math.round((Math.random() * 10 + i)));
            dq.put(student);
        }
        System.out.println("dq.peek():" + dq.peek().getName());
    }
}

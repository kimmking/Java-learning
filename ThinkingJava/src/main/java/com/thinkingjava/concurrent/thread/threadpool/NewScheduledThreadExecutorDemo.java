/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.thinkingjava.concurrent.thread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangwei on 16/4/3.
 */
public class NewScheduledThreadExecutorDemo {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1000);

        try {
            String str = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "I am a task, which submited by the so called laoda, and run by those anonymous workers";
                }
            }).get();

            System.out.println("str=" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10000; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start:" + no);
                        Thread.sleep(1000L);
                        System.out.println("end:" + no);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            // 1min后执行
            executorService.schedule(runnable, 1, TimeUnit.MINUTES);
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");


    }

}

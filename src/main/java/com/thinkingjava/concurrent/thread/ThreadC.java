package com.thinkingjava.concurrent.thread;

import java.util.concurrent.Callable;

/**
 * Created by wangwei on 16/2/19.
 */
public class ThreadC implements Callable<String> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println("这是线程C");
        return "线程C";
    }



}

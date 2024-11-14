package com.dat.thread.thead_local;

import static java.lang.Math.random;

public class MyRunnable implements Runnable {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    @Override
    public void run() {
        threadLocal.set((int)(random() * 100));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println(threadLocal.get());
    }
}

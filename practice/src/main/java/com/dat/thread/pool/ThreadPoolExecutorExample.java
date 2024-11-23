package com.dat.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                1,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(2)
        );
        for (int i = 0; i < 6; i++) {
            int task = i;
            executor.execute(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + task + " is running on thread " + threadName);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + task + " is completed on thread " + threadName);
            });
        }
        executor.shutdown();
    }
}

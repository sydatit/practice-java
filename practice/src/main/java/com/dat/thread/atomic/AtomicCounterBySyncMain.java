package com.dat.thread.atomic;

import com.dat.thread.atomic.usesynchronized.AtomicCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class AtomicCounterBySyncMain {
    private static AtomicCounter counter = new AtomicCounter(0);
    public static void main(String[] args) throws InterruptedException {
        long threadCount = 10;
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[(int) threadCount];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000_000; j++) {
                    counter.incrementAndGet();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) thread.join();

        System.out.println(counter.get());
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }
}

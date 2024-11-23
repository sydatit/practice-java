package com.dat.thread.atomic;

import com.dat.thread.atomic.volatileandCAS.AtomicCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicCounterWay2 {
    private static final AtomicCounter counter = new AtomicCounter();
    private static int counterNotSafe = 0;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        Thread[] threads = new Thread[threadCount];
        long start = System.currentTimeMillis();
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
        System.out.println("--------------------");

//        ExecutorService pool2 = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 5; i++) {
//            pool2.execute(() -> {
//                for (int j = 0; j < 10000; j++) {
//                    counterNotSafe++;
//                }
//            });
//        }
//        pool2.shutdown();
//        pool2.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
//        System.out.println(counterNotSafe);
    }
}

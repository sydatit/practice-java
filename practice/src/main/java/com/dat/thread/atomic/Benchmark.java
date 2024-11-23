package com.dat.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Benchmark {
    private static int synchronizedCounter = 0;
    private static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static synchronized void incrementSynchronized() {
        synchronizedCounter++;
    }

    public static void incrementAtomic() {
        atomicCounter.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        int iterations = 1_000_000;

        Thread[] threads = new Thread[threadCount];

        // Benchmark synchronized
        long startSynchronized = System.nanoTime();
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    incrementSynchronized();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) thread.join();
        long endSynchronized = System.nanoTime();

        // Benchmark AtomicInteger
        long startAtomic = System.nanoTime();
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    incrementAtomic();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) thread.join();
        long endAtomic = System.nanoTime();

        System.out.println("Synchronized Time: " + (endSynchronized - startSynchronized) / 1_000_000 + " ms");
        System.out.println("Atomic Time: " + (endAtomic - startAtomic) / 1_000_000 + " ms");
    }
}

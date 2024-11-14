package com.dat.thread.safe.volatite_atomic.atomic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerAtomicExample {
    private AtomicInteger count = new AtomicInteger(0);
    private final Map map = new ConcurrentHashMap();

    private void start() {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int value;
                while ((value = count.incrementAndGet()) <= 1000_000) {
                    map.put(value, value);
                }
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntegerAtomicExample example = new IntegerAtomicExample();
        example.start();
        Thread.sleep(3000);
        System.out.println(example.map.size());
    }
}

package com.dat.thread.safe.volatite_atomic.violating;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VolatileExample {
    private volatile int count;
    private final Map map = new ConcurrentHashMap();

    public void start() {
        Thread[]  threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                while (count <= 1000000) {
                    ++ count;
                    map.put(Integer.valueOf(count), Integer.valueOf(count));
                }
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();
        example.start();
        Thread.sleep(3000);
        System.out.println(example.map.size());
    }
}

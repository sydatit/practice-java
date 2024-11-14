package com.dat.thread.safe.volatite_atomic.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicExample {
    private AtomicBoolean active = new AtomicBoolean(false);

    private void prepare() {
        new Thread(() -> {
            System.out.println("application preparing ...");
            sleep(3);
            active.set(true);
        })
                .start();
    }

    private void start() {
        new Thread(() -> {
            while (!active.get()) ;
            System.out.println("application started");
        })
                .start();
    }

    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AtomicExample example = new AtomicExample();
        example.prepare();
        example.start();
        sleep(10);
    }
}

package com.dat.thread.safe.volatite_atomic;

public class VolatileBooleanExample {
    private volatile boolean active;
    public static void main(String[] args) {
        VolatileBooleanExample example = new VolatileBooleanExample();
        example.prepare();
        example.start();
        sleep(10);
    }

    private static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void prepare() {
        new Thread(() -> {
            System.out.println("application prepare .....");
            sleep(3);
            active = true;
        })
                .start();

    }

    public void start() {
        new Thread(() -> {
            while (!active);
            System.out.println("application started");
        })
                .start();
    }
}

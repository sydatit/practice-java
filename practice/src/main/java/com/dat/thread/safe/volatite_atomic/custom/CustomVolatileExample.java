package com.dat.thread.safe.volatite_atomic.custom;

public class CustomVolatileExample {
    private final Volatile<Boolean> active = new Volatile<>(false);

    private static void sleep(int second) {
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        CustomVolatileExample example = new CustomVolatileExample();
        example.prepare();
        example.start();
        sleep(10);
    }

    public void prepare() throws InterruptedException {
        new Thread(() -> {
            System.out.println("application preparing ...");
            sleep(3);
            active.set(true);
        })
                .start();
    }

    public void start() throws Exception {
        new Thread(() -> {
            while (!active.get()) ;
            System.out.println("application started");
        })
                .start();
    }
}

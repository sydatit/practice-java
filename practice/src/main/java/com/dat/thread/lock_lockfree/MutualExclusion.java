package com.dat.thread.lock_lockfree;

import java.util.stream.IntStream;

public class MutualExclusion {
    private static int COUNTER = 0;

    public static void main(String[] args) throws InterruptedException {
        final Runnable increaseCounterFun = () -> IntStream
                .range(0, 100)
                .forEach(MutualExclusion::increaseCounter);

        final Thread first = new Thread(increaseCounterFun);
        final Thread second = new Thread(increaseCounterFun);

        first.start();
        second.start();

        first.join();
        second.join();
//        Thread.sleep(15000);
        System.out.println(COUNTER);
    }

    private static void increaseCounter(int i) {
        ++COUNTER;
    }
}

package com.dat.thread.lock_lockfree;

import java.util.stream.IntStream;

public class Example {
    private static int COUNTER = 0;

    public static void main(String... args) throws Exception {

        final Runnable increaseCounterFunc = () -> IntStream
                .range(0, 100)
                .forEach(Example::increaseCounter);

        final var first = new Thread(increaseCounterFunc);
        final var second = new Thread(increaseCounterFunc);

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(COUNTER);
    }

    private static void increaseCounter(int i) {
        ++COUNTER;
    }
}

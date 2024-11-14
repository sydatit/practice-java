package com.dat.thread.lock_lockfree.ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ReentrantLockExample {
    private static int COUNTER = 0;
    private static Lock LOCK = new ReentrantLock();

    public static void main(String... args) throws InterruptedException {
        final Runnable increaseCounterFunc = () -> IntStream
                .range(0, 100)
                .forEach(ReentrantLockExample::increaseCounter);
        final var first = new Thread(increaseCounterFunc);
        final var second = new Thread(increaseCounterFunc);

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(COUNTER);
    }

    private static void increaseCounter(int i) {
        LOCK.lock();
        LOCK.lock();
        ++COUNTER;
        LOCK.unlock();
        LOCK.unlock();
    }
}

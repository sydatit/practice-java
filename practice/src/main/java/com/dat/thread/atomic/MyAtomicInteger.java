package com.dat.thread.atomic;

public class MyAtomicInteger {
    private volatile int value;

    public MyAtomicInteger(int initialValue) {
        this.value = initialValue;
    }

    public int incrementAndGet() {
        while (true) {
            int current = value;
            int newValue = current + 1;
            if (compareAndSet(current, newValue)) {
                return newValue;
            }
        }
    }

    public int get() {
        return value;
    }

    private synchronized boolean compareAndSet(int expect, int update) {
        if (value == expect) {
            value = update;
            return true;
        }
        return false;
    }
}

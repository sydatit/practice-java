package com.dat.thread.safe.volatite_atomic.custom;

public class Volatile<T> {
    private boolean changed;
    private T value;

    public Volatile(T intValue) {
        this.value = intValue;
    }

    public synchronized void set(T newValue) {
        value = newValue;
        changed = true;
        notifyAll();
    }

    public synchronized T get() {
        while (!changed) {
            try {
                System.out.println("I'm waiting here");
                wait();
            } catch (Exception e) {

            }
        }
        changed = false;
        return value;
    }
}

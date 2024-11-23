package com.dat.thread.atomic.usesynchronized;

public class AtomicCounter {
    private int value;

    public AtomicCounter(int initialValue) {
        this.value = initialValue;
    }

    public synchronized int incrementAndGet() {
        return ++value; // Tăng giá trị và trả về
    }

    public synchronized int get() {
        return value; // Lấy giá trị hiện tại
    }

    public synchronized void set(int newValue) {
        this.value = newValue; // Đặt giá trị mới
    }
}

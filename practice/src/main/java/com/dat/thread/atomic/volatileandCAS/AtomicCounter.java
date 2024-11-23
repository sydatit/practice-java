package com.dat.thread.atomic.volatileandCAS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class AtomicCounter {
    private Unsafe unsafe;
    private volatile long counter = 0;
    private long offset;

    private Unsafe getUnsafe() throws IllegalAccessException, NoSuchFieldException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    public AtomicCounter() {
        try {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(AtomicCounter.class.getDeclaredField("counter"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public long incrementAndGet() {
        long before = counter;
        System.out.println("Offset: " + offset);
        while (!unsafe.compareAndSwapLong(this, offset, before, before + 1)) {
            before = counter;
        }
        return (before + 1);
    }

    public long get() {
        return counter;
    }
}

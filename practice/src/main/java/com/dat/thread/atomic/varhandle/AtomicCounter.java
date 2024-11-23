package com.dat.thread.atomic.varhandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class AtomicCounter {
    private volatile int value;

    private static final VarHandle VALUE_HANDLE;

    static {
        try {
            VALUE_HANDLE = MethodHandles.lookup()
                    .findVarHandle(AtomicCounter.class, "value", int.class);
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    public AtomicCounter(int initialValue) {
        this.value = initialValue;
    }

    public int incrementAndGet() {
        int current;
        do {
            current = (int) VALUE_HANDLE.getVolatile(this); // Lấy giá trị hiện tại
        } while (!VALUE_HANDLE.compareAndSet(this, current, current + 1)); // So sánh và đổi
        return current + 1; // Trả về giá trị sau khi tăng
    }

    public int get() {
        return (int) VALUE_HANDLE.getVolatile(this); // Lấy giá trị hiện tại
    }
}

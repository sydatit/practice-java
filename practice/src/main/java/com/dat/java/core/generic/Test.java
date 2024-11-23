package com.dat.java.core.generic;

public class Test<T> {
    private final T obj;

    public Test(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}

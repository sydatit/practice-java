package com.dat.java.core.generic;

import java.util.LinkedList;

public class Queue<T, X> {
    private LinkedList<X> items = new LinkedList<>();
    private T key;

    public void enqueue(X item) {
        items.addLast(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}

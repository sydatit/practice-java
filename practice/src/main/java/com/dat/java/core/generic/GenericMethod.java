package com.dat.java.core.generic;

public class GenericMethod {
    public static <T> void printArray(T[] array) {
        for (T e :array) {
            System.out.println(e);
        }
    }

    public <T, U> T getFirstEle(T[] array, U extra) {
        return array.length > 0 ? array[0] : null;
    }
}

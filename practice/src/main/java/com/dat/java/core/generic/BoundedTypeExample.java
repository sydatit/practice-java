package com.dat.java.core.generic;

public class BoundedTypeExample {
    public static <T extends Number> void printDoubleValue(T num) {
        System.out.println(num.doubleValue());
    }

    public static void main(String[] args) {
        printDoubleValue(10);
        printDoubleValue(3.14);
    }
}

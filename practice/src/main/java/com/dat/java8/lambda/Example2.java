package com.dat.java8.lambda;

interface Addition {
    void add(int a, int b);
}

public class Example2 {
    public static void main(String[] args) {
        Addition addition = (a, b) -> System.out.println("a + b = " + (a + b));
        addition.add(3,5);
    }
}

package com.dat.java8.methodreference;

import java.util.function.Consumer;

public class InstanceMethodMain {
    public static void main(String[] args) {
        String message = "Hello, Java 8";
        Consumer<String> print = x -> System.out.println(x);

        Consumer<String> printReference = System.out::println;
        printReference.accept(message);
    }
}

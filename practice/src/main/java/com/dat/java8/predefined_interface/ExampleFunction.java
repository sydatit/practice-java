package com.dat.java8.predefined_interface;

import java.util.function.Function;

public class ExampleFunction {
    public static void main(String[] args) {
        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("javamultiplex"));
    }
}

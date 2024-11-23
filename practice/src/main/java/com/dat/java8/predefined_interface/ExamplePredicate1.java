package com.dat.java8.predefined_interface;

import java.util.function.Predicate;

public class ExamplePredicate1 {
    public static void main(String[] args) {
        Predicate<Integer> predicate = a -> a > 10;
        System.out.println(predicate.test(3));
        System.out.println(predicate.test(12));
    }
}

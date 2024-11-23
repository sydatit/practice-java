package com.dat.java8.methodreference;

import java.util.function.Supplier;

public class ConstructorRefMain {
    public static void main(String[] args) {
        Supplier<StringBuilder> lambda = () -> new StringBuilder();

        Supplier<StringBuilder> reference = StringBuilder::new;

        StringBuilder sb = reference.get();
        System.out.println("Create: " + sb);
    }
}

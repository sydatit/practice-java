package com.dat.java8.predefined_interface;

import java.util.function.Supplier;

public class SupplierExample1 {
    public static void main(String[] args) {
        String[] foods = {"Burger", "Pizza", "Pasta", "French Fries", "Sandwich"};
        Supplier<String> supplier = () -> {
            int i = (int) (Math.random() * 4 + 1);
            return foods[i];
        };
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }
}

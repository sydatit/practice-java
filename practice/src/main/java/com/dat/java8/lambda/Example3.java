package com.dat.java8.lambda;

interface Length {
    int getLength(String s);
}

public class Example3 {
    public static void main(String[] args) {
        Length length = s -> s.length();
        int l1 = length.getLength("Javamultiplex");
        int l2 = length.getLength("Google");
        System.out.println("Length 1 " + l1);
        System.out.println("Length 2 " + l2);
    }
}

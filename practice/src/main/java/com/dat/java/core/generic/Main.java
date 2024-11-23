package com.dat.java.core.generic;

public class Main {
    static <T> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " = " + element);

    }
    public static void main(String[] args) {
        Test<Integer> iob = new Test<>(88);
        System.out.println(iob.getObj());

        Test<String> sob = new Test<>("Hello Generics");
        System.out.println(sob.getObj());

        System.out.println("-----------------");
        genericDisplay(11);
        genericDisplay("Generics Test");
    }
}

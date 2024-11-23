package com.dat.java.core.generic;

import java.util.ArrayList;

public class ExampleWithoutTypeSafety {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(10);
        al.add("Hello");
        System.out.println(al);
        for (Object a:al
        ) {
            String s = (String) a; // ClassCastException
            System.out.println(s);
        }
    }
}

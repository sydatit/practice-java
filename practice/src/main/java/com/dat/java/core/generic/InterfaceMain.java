package com.dat.java.core.generic;

public class InterfaceMain {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new KeyValue<>("Dat", 26);
        System.out.println(pair.getKey() + " : " + pair.getValue());
    }
}

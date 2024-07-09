package com.dat.java.core.map;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("foo", 1);
        map.put("bar", 2);
        map.put("baz", 3);
        System.out.println(map.get("bar"));
        System.out.println(map.size());

        map.remove("bar");
        System.out.println(map.get("bar"));
        System.out.println(map.size());
    }
}

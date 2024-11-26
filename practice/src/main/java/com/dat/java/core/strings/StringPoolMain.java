package com.dat.java.core.strings;

public class StringPoolMain {
    public static void main(String[] args) {
        String s1 = "hellofwafawefawfawefwea";
        String s2 = "hellofwafawefawfawefwea";
        System.out.println(s1 == s2); // true (cùng tham chiếu trong String Pool)

    }
}

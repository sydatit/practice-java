package com.dat.java.core.enums;

public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(DAY.MONDAY.getVietnameseName());
        DAY.MONDAY.setVietnameseName("Thứ ba");
        System.out.println(DAY.MONDAY.getVietnameseName());
    }
}

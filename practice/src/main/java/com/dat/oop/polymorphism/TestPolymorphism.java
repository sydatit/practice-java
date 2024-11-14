package com.dat.oop.polymorphism;

public class TestPolymorphism {
    public static void main(String[] args) {
        Bank backSBI = new SBI();
        System.out.println("SBI Rate of Interest: " + backSBI.getRateOfInterest());
        Bank backICICI = new ICICI();
        System.out.println("ICICI Rate of Interest: " + backICICI.getRateOfInterest());
        Bank backAXIS = new AXIS();
        System.out.println("AXIS Rate of Interest: " + backAXIS.getRateOfInterest());
    }
}

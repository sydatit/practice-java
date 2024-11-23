package com.dat.design_pattern.proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("First call to display photo1: ");
        image1.display();

        System.out.println("Second call to display photo1: ");
        image1.display();

        System.out.println("Displaying photo2: ");
        image2.display();
    }
}

package com.dat.solid.lip.good;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(5, 10);
        System.out.println("Area of Rectangle: " + rect.getArea()); // 50 (OK)

        Shape square = new Square(5);
        System.out.println("Area of Square: " + square.getArea()); // 25 (OK)
    }
}

package com.dat.solid.lip;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.setWidth(5);
        rect.setHeight(10);
        System.out.println("Area of Rectangle: " + rect.getArea()); // 50 (OK)

        // Thay thế Rectangle bằng Square
        Rectangle square = new Square();
        square.setWidth(5);
        square.setHeight(10); // Lỗi: width và height bị thay đổi đồng thời
        System.out.println("Area of Square: " + square.getArea()); // Kết quả sai
    }
}

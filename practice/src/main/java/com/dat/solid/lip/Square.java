package com.dat.solid.lip;

class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Ràng buộc: width == height
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // Ràng buộc: width == height
    }
}
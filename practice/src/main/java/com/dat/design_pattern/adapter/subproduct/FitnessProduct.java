package com.dat.design_pattern.adapter.subproduct;

import com.dat.design_pattern.adapter.Product;

public class FitnessProduct implements Product {
    private String name;
    private double price;

    public FitnessProduct() {
    }

    public FitnessProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

package com.dat.design_pattern.adapter;

import java.util.ArrayList;
import java.util.List;

public class ShopInventory {
    private List<Product> products;

    public ShopInventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
}

package com.dat.design_pattern.adapter;

public class GroceryItemAdapter implements Product {
    private GroceryItem groceryItem;

    public GroceryItemAdapter(GroceryItem groceryItem) {
        this.groceryItem = groceryItem;
    }

    @Override
    public String getName() {
        return groceryItem.getItemName();
    }

    @Override
    public double getPrice() {
        return groceryItem.getCostPerUnit();
    }
}

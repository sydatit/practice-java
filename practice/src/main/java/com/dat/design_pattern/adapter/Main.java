package com.dat.design_pattern.adapter;

import com.dat.design_pattern.adapter.subproduct.CosmeticProduct;
import com.dat.design_pattern.adapter.subproduct.FitnessProduct;

public class Main {
    public static void main(String[] args) {
        ShopInventory shopInventory = new ShopInventory();
        CosmeticProduct cosmeticProduct = new CosmeticProduct("Lipstick", 10);
        FitnessProduct fitnessProduct = new FitnessProduct("Dumbbell", 20);
        shopInventory.addProduct(cosmeticProduct);
        shopInventory.addProduct(fitnessProduct);


        GroceryItem groceryItem = new GroceryItem("Apple", 2);
        GroceryItemAdapter groceryItemAdapter = new GroceryItemAdapter(groceryItem);
        shopInventory.addProduct(groceryItemAdapter);
    }
}

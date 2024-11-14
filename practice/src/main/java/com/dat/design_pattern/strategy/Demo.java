package com.dat.design_pattern.strategy;

import com.dat.design_pattern.strategy.order.Order;
import com.dat.design_pattern.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args) {
        while (!order.isClosed()) {
            int cost;
            String continueChoice;

        }
    }
}

package com.dat.design_pattern.decorator;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new JalapenoPizza(new CheeseBurstPizza(new BasePizza()));
        System.out.println(pizza.bake());
    }
}

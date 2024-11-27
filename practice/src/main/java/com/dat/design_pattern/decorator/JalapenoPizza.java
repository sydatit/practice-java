package com.dat.design_pattern.decorator;

public class JalapenoPizza extends PizzaDecorator {
    public JalapenoPizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bake() {
        return super.bake() + addJalapeno();
    }

    private String addJalapeno() {
        return " + Jalapeno";
    }
}

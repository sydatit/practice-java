package com.dat.design_pattern.decorator;

public class CheeseBurstPizza extends PizzaDecorator {

    public CheeseBurstPizza(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String bake() {
        return super.bake() + addCheese();
    }

    private String addCheese() {
        return " + Cheese";
    }
}

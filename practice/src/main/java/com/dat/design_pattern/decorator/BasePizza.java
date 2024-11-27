package com.dat.design_pattern.decorator;

public class BasePizza implements Pizza {
    @Override
    public String bake() {
        return "Base Pizza";
    }
}

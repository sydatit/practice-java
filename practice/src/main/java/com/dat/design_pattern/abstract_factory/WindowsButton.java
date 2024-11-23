package com.dat.design_pattern.abstract_factory;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a Windows Button");
    }
}

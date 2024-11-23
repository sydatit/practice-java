package com.dat.design_pattern.abstract_factory;

public class MacOSButton implements Button {

    @Override
    public void paint() {
        System.out.println("Rendering a MacOS Button");
    }
}

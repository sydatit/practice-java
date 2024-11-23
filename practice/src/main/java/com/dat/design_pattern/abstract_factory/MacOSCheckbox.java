package com.dat.design_pattern.abstract_factory;

public class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a MacOS checkbox");
    }
}

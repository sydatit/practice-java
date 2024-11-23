package com.dat.design_pattern.abstract_factory;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a Windows Checkbox");
    }
}

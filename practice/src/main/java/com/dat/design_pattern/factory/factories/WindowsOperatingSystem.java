package com.dat.design_pattern.factory.factories;

public class WindowsOperatingSystem extends OperatingSystem {
    public WindowsOperatingSystem(String version, String architecture) {
        super(version, architecture);
    }

    public WindowsOperatingSystem() {
    }

    @Override
    public void changeDir(String dir) {

    }

    @Override
    public void removeDir(String dir) {

    }
}

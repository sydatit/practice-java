package com.dat.design_pattern.factory;

import com.dat.design_pattern.factory.factories.LinuxOperatingSystem;
import com.dat.design_pattern.factory.factories.OperatingSystem;
import com.dat.design_pattern.factory.factories.WindowsOperatingSystem;

public class OperatingSystemFactory {

    public static OperatingSystem getInstance(String osType, String version, String architecture) {
        switch (osType) {
            case "Linux":
                return new LinuxOperatingSystem(version, architecture);
            case "Windows":
                return new WindowsOperatingSystem(version, architecture);
            default:
                throw new IllegalArgumentException("Invalid Operating System Type");
        }
    }
}

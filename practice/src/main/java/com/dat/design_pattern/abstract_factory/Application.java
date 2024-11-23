package com.dat.design_pattern.abstract_factory;

import com.dat.design_pattern.abstract_factory.factories.GUIFactory;
import com.dat.design_pattern.abstract_factory.factories.MacOSFactory;
import com.dat.design_pattern.abstract_factory.factories.WindowsFactory;

public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory guiFactory) {
        button = guiFactory.createButton();
        checkbox = guiFactory.createCheckbox();
    }

    public void render() {
        button.paint();
        checkbox.paint();
    }

    public static void main(String[] args) {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOSFactory();
        } else {
            factory = new WindowsFactory();
        }
        Application app = new Application(factory);
        app.render();
    }
}

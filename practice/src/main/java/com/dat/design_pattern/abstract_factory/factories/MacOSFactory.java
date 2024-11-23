package com.dat.design_pattern.abstract_factory.factories;

import com.dat.design_pattern.abstract_factory.Button;
import com.dat.design_pattern.abstract_factory.Checkbox;
import com.dat.design_pattern.abstract_factory.MacOSButton;
import com.dat.design_pattern.abstract_factory.MacOSCheckbox;

public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

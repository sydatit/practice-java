package com.dat.design_pattern.abstract_factory.factories;

import com.dat.design_pattern.abstract_factory.Button;
import com.dat.design_pattern.abstract_factory.Checkbox;
import com.dat.design_pattern.abstract_factory.WindowsButton;
import com.dat.design_pattern.abstract_factory.WindowsCheckbox;
import com.dat.design_pattern.abstract_factory.factories.GUIFactory;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

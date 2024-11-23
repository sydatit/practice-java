package com.dat.design_pattern.abstract_factory.factories;

import com.dat.design_pattern.abstract_factory.Button;
import com.dat.design_pattern.abstract_factory.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

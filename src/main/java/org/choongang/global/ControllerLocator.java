package org.choongang.global;

import org.choongang.global.constants.Menu;

public interface ControllerLocator {
        Controller find(Menu menu);
}

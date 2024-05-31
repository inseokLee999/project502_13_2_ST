package org.choongang.global;

import org.choongang.global.constants.MainMenu;

public interface ServiceLocator {
    Service find(MainMenu menu);
}

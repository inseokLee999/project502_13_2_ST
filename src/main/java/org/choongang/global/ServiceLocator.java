package org.choongang.global;

import org.choongang.global.constants.Menu;

public interface ServiceLocator {
    Service find(Menu menu);
}

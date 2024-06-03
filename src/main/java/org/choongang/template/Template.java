package org.choongang.template;

import java.util.function.Supplier;

public interface Template {
    String getTpl();
    default void addHook(Supplier<String> supplier){}
}

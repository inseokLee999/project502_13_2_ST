package org.choongang.global;

import org.choongang.subject.entities.Subject;

public interface Service<T>{
    default void process(T form){};
    default T process(){return null;}
    default void process(T... params){}

    default Subject process(int subCode){return null;};
}

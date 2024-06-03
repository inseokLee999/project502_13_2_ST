package org.choongang.global;

import org.choongang.subject.entities.Subject;

import java.util.List;

public interface Service<T>{
    default void process(T form){};
    default T process(){return null;}
    default void process(T... params){}

    default List<T> process(int number){return null;}
    default T process(long userNo){return null;}
}

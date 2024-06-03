package org.choongang.global;

import org.choongang.subject.entities.Subject;

import java.util.List;

public interface Service<T>{
    default void process(T form){};
    default T process(){return null;}
    default void process(T... params){}

    default List<Subject> process(int subCode){return null;};
    default List<T> attendReadProcess(long attendCode){return  null;}
    default T process(long userNo){return null;}
//    default int process(int subCode){
//        return 0;
//    }
}

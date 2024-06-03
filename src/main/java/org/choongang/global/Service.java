package org.choongang.global;

import org.choongang.subject.entities.Subject;

import java.util.List;

public interface Service<T>{
    default void process(T form){};
    default T process(){return null;}
    default void process(T... params){}

    default List<T> process(int subCode){return null;};
    default int process1(int subCode){return 0;}
    default int process2(int userNo){return 0;}
    default T process(long userNo){return null;}
//    default int process(int subCode){
//        return 0;
//    }
}

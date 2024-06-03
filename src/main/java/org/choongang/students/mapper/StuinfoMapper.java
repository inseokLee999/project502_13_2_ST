package org.choongang.students.mapper;

import org.choongang.students.entities.Stuinfo;
import org.choongang.subject.entities.Subject;

import java.util.List;

public interface StuinfoMapper {
    List<Stuinfo> getList();
    Stuinfo get(long userNo);
    int register(Stuinfo stuinfo);
    int delete(long userNo);
    int modify(Stuinfo stuinfo);
    int exists(Stuinfo stuinfo);
}


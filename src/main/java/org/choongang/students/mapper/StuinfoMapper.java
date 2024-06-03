package org.choongang.students.mapper;

import org.choongang.students.entities.StuInfo;

import java.util.List;

public interface StuinfoMapper {
    List<StuInfo> getList();
    StuInfo get(long userNo);
    int register(StuInfo stuinfo);
    int delete(long userNo);
    int modify(StuInfo stuinfo);
    int exists(StuInfo stuinfo);
}


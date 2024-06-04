package org.choongang.students.mapper;

import org.choongang.students.entities.StuInfo;

import java.util.List;

public interface StuInfoMapper {
    List<StuInfo> getList();
    StuInfo get(int userNo);
    int register(StuInfo stuinfo);
    int delete(int userNo);
    int modify(StuInfo stuinfo);
    int exists(int userNo);
}


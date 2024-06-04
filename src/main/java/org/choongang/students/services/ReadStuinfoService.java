package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.StuInfo;
import org.choongang.students.mapper.StuInfoMapper;

import java.util.List;


public class ReadStuinfoService implements Service<StuInfo> {

    private final StuInfoMapper mapper;

    public ReadStuinfoService (StuInfoMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public StuInfo process3(int userNo) {
        if (mapper.exists(userNo)>0) {
            return mapper.get(userNo);
        }
        return null;
    }
}



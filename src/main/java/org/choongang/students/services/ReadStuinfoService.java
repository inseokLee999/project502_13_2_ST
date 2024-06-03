package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.StuInfo;
import org.choongang.students.mapper.StuinfoMapper;


public class ReadStuinfoService implements Service<StuInfo> {

    private final StuinfoMapper mapper;

    public ReadStuinfoService (StuinfoMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public StuInfo process(long userNo) {
        if (mapper.exists(userNo)>0) {
            return mapper.get(userNo);
        }
        return null;
    }
}



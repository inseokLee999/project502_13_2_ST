package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.StuInfo;
import org.choongang.students.mapper.StuinfoMapper;


public class DeleteStuinfoService implements Service<StuInfo> {

    private final StuinfoMapper mapper;

    public DeleteStuinfoService(StuinfoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int process2(int userNo) {
        if (mapper.exists(userNo) > 0) {
            return mapper.delete(userNo);
        } else throw new RuntimeException();
    }
}


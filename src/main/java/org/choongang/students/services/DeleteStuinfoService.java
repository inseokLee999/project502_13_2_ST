package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.StuInfo;
import org.choongang.students.mapper.StuInfoMapper;


public class DeleteStuinfoService implements Service<StuInfo> {

    private final StuInfoMapper mapper;

    public DeleteStuinfoService(StuInfoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int process2(int userNo) {
        if (mapper.exists(userNo) > 0) {
            return mapper.delete(userNo);
        }

        return 0;
    }
}


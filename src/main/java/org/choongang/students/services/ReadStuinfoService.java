package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.Stuinfo;
import org.choongang.students.mapper.StuInfoMapper;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.mapper.SubjectMapper;

public class ReadStuinfoService implements Service<Stuinfo> {

    private final StuInfoMapper mapper;

    public ReadStuinfoService (StuInfoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Subject process(int userNo) {
        return mapper.get(userNo);
    }
}



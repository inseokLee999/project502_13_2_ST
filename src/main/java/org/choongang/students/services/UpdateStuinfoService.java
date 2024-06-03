package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.Stuinfo;
import org.choongang.students.mapper.StuInfoMapper;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.mapper.SubjectMapper;

public class UpdateStuinfoService implements Service<Stuinfo> {

    private final StuInfoMapper mapper;

    public UpdateStuinfoService(StuInfoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Stuinfo stuinfo) {
        if(mapper.exists(stuinfo)>0){
            mapper.modify(stuinfo);
        }else{
            mapper.register(stuinfo);
        }
    }
}

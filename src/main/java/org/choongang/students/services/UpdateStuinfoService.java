package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.StuInfo;
import org.choongang.students.mapper.StuInfoMapper;


public class UpdateStuinfoService implements Service<StuInfo> {

    private final StuInfoMapper mapper;

    public UpdateStuinfoService(StuInfoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(StuInfo stuinfo) {
        if(mapper.exists(stuinfo.getUserNo())>0){
            mapper.modify(stuinfo);
        }else{
            throw new RuntimeException();
        }
    }
}

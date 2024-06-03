package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.StuInfo;
import org.choongang.students.mapper.StuinfoMapper;

public class CreateStuinfoService implements Service<StuInfo> {

    private final StuinfoMapper mapper;

    public CreateStuinfoService (StuinfoMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void process(StuInfo form) {
        mapper.register(form);
    }


    }



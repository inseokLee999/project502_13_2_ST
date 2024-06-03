package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.Stuinfo;
import org.choongang.students.mapper.StuInfoMapper;

public class CreateStuinfoService implements Service<Stuinfo> {

    private final StuInfoMapper mapper;

    public CreateStuinfoService (StuInfoMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void process(Stuinfo form) {
        mapper.register(form);
    }


    }



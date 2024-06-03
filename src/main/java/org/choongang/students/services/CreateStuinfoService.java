package org.choongang.students.services;

import org.choongang.global.Service;
import org.choongang.students.entities.Stuinfo;
import org.choongang.students.mapper.StuinfoMapper;

public class CreateStuinfoService implements Service<Stuinfo> {

    private final StuinfoMapper mapper;

    public CreateStuinfoService (StuinfoMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void process(Stuinfo form) {
        mapper.register(form);
    }


    }



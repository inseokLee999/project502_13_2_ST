package org.choongang.attend.service;

import org.choongang.attend.entities.Attend;
import org.choongang.attend.mapper.AttendMapper;
import org.choongang.global.Service;
import org.choongang.subject.entities.Subject;

public class AttendCreateService implements Service<Attend> {
    private final AttendMapper mapper;

    public AttendCreateService(AttendMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public void process(Attend form){
        mapper.register(form);
    }
}

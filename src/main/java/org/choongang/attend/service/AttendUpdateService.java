package org.choongang.attend.service;

import org.choongang.attend.entities.Attend;
import org.choongang.attend.mapper.AttendMapper;
import org.choongang.global.Service;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.mapper.SubjectMapper;

public class AttendUpdateService implements Service<Attend> {
    private final AttendMapper mapper;

    public AttendUpdateService(AttendMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Attend attend) {
        if(mapper.exists(attend)>0){
            mapper.modify(attend);
        }else{
            mapper.register(attend);
        }
    }
}

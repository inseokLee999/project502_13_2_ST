package org.choongang.attend.service;

import org.choongang.attend.entities.Attend;
import org.choongang.attend.mapper.AttendMapper;
import org.choongang.global.Service;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.mapper.SubjectMapper;

public class AttendDeleteService implements Service<Attend> {
    private final AttendMapper mapper;

    public AttendDeleteService(AttendMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int process2(int attendCode) {
        if(mapper.exists(attendCode)>0){
            return mapper.delete(attendCode);
        }
        return 0;
    }
}



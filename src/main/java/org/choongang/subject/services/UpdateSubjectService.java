package org.choongang.subject.services;

import org.choongang.global.Service;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.mapper.SubjectMapper;

public class UpdateSubjectService implements Service<Subject> {
    private final SubjectMapper mapper;

    public UpdateSubjectService(SubjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Subject subject) {
        if(mapper.exists(subject.getSubCode())>0){
            mapper.modify(subject);
        }else{
            throw new RuntimeException();
        }
    }
}

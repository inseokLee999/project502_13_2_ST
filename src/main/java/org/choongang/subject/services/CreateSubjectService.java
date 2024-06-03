package org.choongang.subject.services;

import org.choongang.global.Service;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.mapper.SubjectMapper;

public class CreateSubjectService implements Service<Subject> {
    private final SubjectMapper mapper;

    public CreateSubjectService(SubjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void process(Subject form) {
        //CREATE 구현
        mapper.register(form);
    }
}

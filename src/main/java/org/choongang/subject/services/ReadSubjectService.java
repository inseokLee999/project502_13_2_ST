package org.choongang.subject.services;

import org.choongang.global.Service;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.mapper.SubjectMapper;

public class ReadSubjectService implements Service<Subject> {
    private final SubjectMapper mapper;

    public ReadSubjectService(SubjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Subject process(int subCode) {
        return mapper.get(subCode);
    }
}

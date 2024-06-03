package org.choongang.subject.services;

import org.choongang.global.Service;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.mapper.SubjectMapper;

import java.util.List;

public class ReadSubjectService implements Service<Subject> {
    private final SubjectMapper mapper;

    public ReadSubjectService(SubjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Subject> process(int subCode) {
        if(mapper.exists(subCode)>0){
            return mapper.get(subCode);
        }
        return null;
    }
}

package org.choongang.subject.services;

import org.choongang.global.Service;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.mapper.SubjectMapper;


public class DeleteSubjectService implements Service<Subject> {
    private final SubjectMapper mapper;


    public DeleteSubjectService(SubjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public int process2(int subCode) {
        if(mapper.exists(subCode)>0){
            return mapper.delete(subCode);
        }

        return 0;
    }
}

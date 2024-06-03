package org.choongang.subject.mapper;

import org.choongang.subject.entities.Subject;

import java.util.List;

public interface SubjectMapper {
    List<Subject> getList();
    List<Subject> get(int subCode);
    int register(Subject subject);
    int delete(int subCode);
    int modify(Subject subject);
    int exists(int subCode);
}

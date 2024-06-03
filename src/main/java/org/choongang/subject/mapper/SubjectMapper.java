package org.choongang.subject.mapper;

import org.choongang.subject.entities.Subject;

import java.util.List;

public interface SubjectMapper {
    List<Subject> getList();
    List<Subject> get(long subCode);
    int register(Subject subject);
    int delete(long subCode);
    int modify(Subject subject);
    int exists(Subject subject);
}

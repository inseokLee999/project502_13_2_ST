package org.choongang.subject.mapper;

import org.choongang.subject.entities.Subject;

import java.util.List;

public interface SubjectInfoMapper {
    List<Subject> getSearch(Subject subject);
}

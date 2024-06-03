package org.choongang.attend.mapper;

import org.choongang.attend.entities.Attend;
import org.choongang.subject.entities.Subject;

import java.util.List;

public interface AttendMapper {
    List<Attend> getList();
    List<Attend> getByStudentName(String studentName);
    Attend get(long subCode);
    int register(Attend attend);
    int delete (long subCode);
    int modify(Attend attend);
    int exists (Attend attend);

}

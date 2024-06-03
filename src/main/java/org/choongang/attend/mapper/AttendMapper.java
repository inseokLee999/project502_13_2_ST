package org.choongang.attend.mapper;

import org.choongang.attend.entities.Attend;
import org.choongang.subject.entities.Subject;

import java.util.List;

public interface AttendMapper {
    List<Attend> getList();
    List<Attend> get(long attendCode);
    int register(Attend attend);
    int delete (long attendCode);
    int modify(Attend attend);
    int exists (long attendCode);

}

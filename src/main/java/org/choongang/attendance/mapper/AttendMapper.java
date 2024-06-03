package org.choongang.attend.mapper;

import org.choongang.attend.entities.Attend;

import java.util.List;

public interface AttendMapper {
    List<Attend> getList();
    List<Attend> getByStudentName(String studentName);
}

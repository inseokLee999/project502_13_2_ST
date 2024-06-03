package org.choongang.students.mapper;

import java.util.List;

public interface StuInfoMapper {
    // 학생 추가
    void addStudent(Student student);

    // 학생 조회
    List<Student> getStudents();

    // 학생 수정
    void updateStudent(Student student);

    // 학생 삭제
    void deleteStudent(int userNo);
}


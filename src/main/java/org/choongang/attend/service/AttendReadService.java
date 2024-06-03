package org.choongang.attend.service;

import org.choongang.attend.entities.Attend;
import org.choongang.attend.mapper.AttendMapper;
import org.choongang.global.Service;

import java.util.List;

public class AttendReadService implements Service<Attend> {
    private final AttendMapper mapper;

    public AttendReadService(AttendMapper mapper) {
        this.mapper = mapper;
    }

    // 학생 이름을 입력받아 해당 학생의 출석 정보를 반환하는 메서드
    public List<Attend> getAttendanceByStudentName(String studentName) {
        return mapper.getByStudentName(studentName);
    }

    @Override
    public void process(Attend form) {
        // 학생 이름을 이용하여 해당 학생의 출석 정보를 가져옵니다.
        List<Attend> attendanceList = getAttendanceByStudentName(form.getStudentName());

        // 여기서 출석 정보를 사용하여 필요한 작업을 수행합니다.
        // 예를 들어, 가져온 출석 정보를 출력하거나 다른 작업을 수행할 수 있습니다.
        for (Attend attend : attendanceList) {
            System.out.println(attend); // 출석 정보 출력 예시
        }

    }
}

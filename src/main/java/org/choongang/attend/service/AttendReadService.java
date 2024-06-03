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



    @Override
    public List<Attend> attendReadProcess(long attendCode) {
        // 학생 이름을 이용하여 해당 학생의 출석 정보를 가져옵니다.
        if(mapper.exists(attendCode)>0){
            return mapper.get(attendCode);
        }
        return null;
    }
}

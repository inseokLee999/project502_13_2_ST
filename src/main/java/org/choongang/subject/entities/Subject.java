package org.choongang.subject.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
/*
SUB_CODE NUMBER(10) PRIMARY KEY,
SUB_NAME VARCHAR2(30) NOT NULL,
PROFESSOR VARCHAR2(10) NOT NULL,
START_TIME VARCHAR2(20),
END_TIME VARCHAR2(20),
SUB_TYPE_1 VARCHAR2(10),
SUB_TYPE_2 VARCHAR2(10),
SUB_CREDIT NUMBER(2),
SUB_HOUR NUMBER(2)*/
public class Subject {
    private int subCode;
    private String subName;
    private String professor;
    private String startTime;
    private String endTime;
    private String subType;
    private int subHour;
    private int subCredit;
}

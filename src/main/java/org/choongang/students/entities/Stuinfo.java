package org.choongang.students.entities;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Stuinfo {
    private long userNo;
    private int grade;
    private String gender;
    private String semester;
    private String dept;
    private int stuCreadit;
    private Date adYr;
    private String eMail;
    private int tel;

}

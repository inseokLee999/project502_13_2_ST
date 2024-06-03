package org.choongang.attend.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attend {
    private long attendCode;
    private String studentName;
    private String department;
    private String studentId;
    private String oneWeek;
    private String twoWeek;
    private String threeWeek;
    private String fourWeek;
    private String fiveWeek;
    private String sixWeek;
    private String sevenWeek;

}

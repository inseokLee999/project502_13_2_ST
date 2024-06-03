package org.choongang.attend.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestAttendInfo {
    private  int attendCode;
}

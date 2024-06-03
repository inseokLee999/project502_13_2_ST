package org.choongang.member.controllers;

import lombok.Builder;
import lombok.Data;
import org.choongang.member.constants.UserType;

@Data
@Builder
public class RequestJoin {
    private String userId;
    private String userPw;
    private String confirmPw;
    private String userNm;
    private UserType userType;
}

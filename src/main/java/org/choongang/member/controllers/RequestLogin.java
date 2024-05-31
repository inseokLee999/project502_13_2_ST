package org.choongang.member.controllers;

import lombok.Builder;
import lombok.Data;
import org.choongang.member.constants.UserType;

@Data @Builder
public class RequestLogin {
    private String userId;
    private String userPw;
    private UserType userType;
}

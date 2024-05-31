package org.choongang.member.services;

import org.choongang.global.Service;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.LoginValidator;

public class LoginService implements Service<RequestLogin> {

    //기본 생성자를 추가
    private MemberMapper memberMapper;
    private LoginValidator loginValidator;

    public LoginService() {
        // 기본 생성자 내용 추가 (필요에 따라)
    }

    // 이전에 있던 생성자
    public LoginService(MemberMapper memberMapper, LoginValidator loginValidator) {
        this.memberMapper = memberMapper;
        this.loginValidator = loginValidator;
    }

    @Override
    public void process(RequestLogin form) {

    }
}

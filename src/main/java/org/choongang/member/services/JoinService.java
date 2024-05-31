package org.choongang.member.services;

import org.choongang.global.Service;
import org.choongang.main.controllers.RequestJoin;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.validators.JoinValidator;

public class JoinService implements Service<RequestJoin> {

    // 기본 생성자를 추가
    private MemberMapper memberMapper;
    private JoinValidator joinValidator;

    public JoinService() {
        // 기본 생성자 내용 추가 (필요에 따라)
    }

    // 이전에 있던 생성자
    public JoinService(MemberMapper memberMapper, JoinValidator joinValidator) {
        this.memberMapper = memberMapper;
        this.joinValidator = joinValidator;
    }

    @Override
    public void process(RequestJoin form) {

    }
}

package org.choongang.member.services;

import org.choongang.global.Service;
import org.choongang.global.exceptions.ValidationException;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.entities.Member;
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
        System.out.println("회원가입 처리 실행");
        joinValidator.check(form);
        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(form.getUserPw())
                .userNm(form.getUserNm())
                .userType(form.getUserType())
                .build();
        System.out.println("회원정보 : "+member.toString());
        int affectedRows = memberMapper.register(member);
        if(affectedRows<1){
            throw new ValidationException("회원가입에 실패했습니다");
        }
    }
}

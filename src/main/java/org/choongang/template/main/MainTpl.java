package org.choongang.template.main;

import org.choongang.member.MemberSession;
import org.choongang.member.constants.UserType;
import org.choongang.member.entities.Member;
import org.choongang.template.Template;

public class MainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("메인 메뉴\n");

        if (MemberSession.isLogin()) { // 로그인 상태
            Member member = MemberSession.getMember();

            switch(member.getUserType()) {
                case STUDENT:
                        // 학생 메뉴 출력
                    sb.append("0. 로그아웃");
                    sb.append("1. 학생 정보 조회(자기 정보)");
                    sb.append("2. 강의 정보 조회");

                    break;
                case ADMIN:
                    // 관리자 메뉴 출력

                    break;
            }


        } else { // 미로그인 상태
            sb.append("1. 회원가입\n");
            sb.append("2. 로그인\n");
        }


        return sb.toString();
    }
}

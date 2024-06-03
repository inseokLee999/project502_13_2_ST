package org.choongang.template.after_login_menu;

import org.choongang.member.MemberSession;
import org.choongang.template.Template;

public class Attend_Manager_Tpl implements Template {
    String userId = MemberSession.getInstance().getUserId();

    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("관리자님 출석현황 수정 페이지입니다\n");
        sb.append("이전화면으로 돌아가려면 1번을 눌러주세요\n");
        sb.append("새로운 학생을 보고 싶으면 2번");
        return sb.toString();
    }
}

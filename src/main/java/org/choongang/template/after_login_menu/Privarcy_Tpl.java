package org.choongang.template.after_login_menu;

import org.choongang.member.MemberSession;
import org.choongang.template.Template;

public class Privarcy_Tpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("학생 정보입니다.\n");
        sb.append("1. 이전 화면\n");
        sb.append("2. 학생정보 조회\n");
        if (MemberSession.isAdmin()) {
            sb.append("3. 학생정보 추가\n");
            sb.append("4. 학생정보 수정\n");
            sb.append("5. 학생정보 삭제\n");
        }
        return sb.toString();
    }
}

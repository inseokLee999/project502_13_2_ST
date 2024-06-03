package org.choongang.template.after_login_menu;

import org.choongang.member.MemberSession;
import org.choongang.template.Template;

public class Subject_Imformation_Tpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("과목정보입니다.\n");
        sb.append("1. 이전 화면\n");
        sb.append("2. 과목 조회\n");
        if (MemberSession.isAdmin()) {
            sb.append("3. 과목 추가\n");
            sb.append("4. 과목 수정\n");
            sb.append("5. 과목 삭제\n");
        }
        return sb.toString();
    }
}

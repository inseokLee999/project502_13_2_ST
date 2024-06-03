package org.choongang.template.after_login_menu;

import org.choongang.template.Template;

public class After_Login_Tpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("환영합니다 사용자님\n");
        sb.append("0. 로그아웃\n");
        sb.append("1. 과목정보\n");
        sb.append("2. 출석정보\n");
        sb.append("3. 학생정보\n");
        return sb.toString();
    }
}

package org.choongang.template.after_login_admin_menu;

import org.choongang.template.Template;

public class After_Login_Adm_Tpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("환영합니다 관리자(교수)님\n");
        sb.append("0. 로그아웃\n");
        sb.append("1. 학생 정보 관리\n");
        sb.append("2.  강의 정보 관리\n");
        sb.append("3. 출석 정보 관리\n");
        return sb.toString();
    }
}

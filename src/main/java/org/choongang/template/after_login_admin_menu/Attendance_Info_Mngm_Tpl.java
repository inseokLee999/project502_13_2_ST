package org.choongang.template.after_login_admin_menu;

import org.choongang.template.Template;

public class Attendance_Info_Mngm_Tpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("출석 정보 관리입니다.\n");
        sb.append("이전화면으로 돌아가려면 1번을 눌러주세요");
        return sb.toString();
    }
}

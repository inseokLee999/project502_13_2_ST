package org.choongang.template.after_login_menu;

import org.choongang.template.Template;

public class Attend_Tpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("사용자님의 출석현황입니다\n");
        sb.append("이전화면으로 돌아가려면 1번을 눌러주세요");
        return sb.toString();
    }
}

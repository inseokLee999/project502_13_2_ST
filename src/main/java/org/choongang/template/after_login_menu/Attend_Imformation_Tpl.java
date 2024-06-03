package org.choongang.template.after_login_menu;

import org.choongang.template.Template;

public class Attend_Imformation_Tpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("학생출석정보입니다.\n");
        sb.append("1. 이전 화면\n");
        sb.append("2. 출석 추가\n");
        sb.append("3. 출석 조회\n");
        sb.append("4. 출석 수정\n");
        sb.append("5. 출석 삭제\n");
        return sb.toString();
    }
}

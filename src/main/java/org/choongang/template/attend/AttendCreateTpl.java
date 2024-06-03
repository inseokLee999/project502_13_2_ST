package org.choongang.template.attend;

import org.choongang.template.Template;

public class AttendCreateTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("출석 추가\n");
        sb.append("원하는 출석 정보를 입력하세요\n");

        return sb.toString();
    }


}

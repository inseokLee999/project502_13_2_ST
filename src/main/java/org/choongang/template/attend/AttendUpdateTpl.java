package org.choongang.template.attend;

import org.choongang.template.Template;

public class AttendUpdateTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("출석 수정\n");
        sb.append("수정할 출석 코드를 입력하세요.\n");

        return sb.toString();
    }
}

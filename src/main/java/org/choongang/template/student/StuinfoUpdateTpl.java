package org.choongang.template.student;

import org.choongang.template.Template;

public class StuinfoUpdateTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("학생 정보 수정\n");
        sb.append("수정할 학생정보 코드를 입력하세요.\n");

        return sb.toString();
    }
}

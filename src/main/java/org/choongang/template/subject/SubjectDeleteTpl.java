package org.choongang.template.subject;

import org.choongang.template.Template;

public class SubjectDeleteTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("과목 삭제\n");
        sb.append("삭제할 과목 정보를 입력하세요\n");

        return sb.toString();
    }
}
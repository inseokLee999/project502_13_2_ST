package org.choongang.template.subject;

import org.choongang.template.Template;

public class SubjectCreateTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("과목 추가\n");
        sb.append("원하는 과목 정보를 입력하세요\n");

        return sb.toString();
    }
}

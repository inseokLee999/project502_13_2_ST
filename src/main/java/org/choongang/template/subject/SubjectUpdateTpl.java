package org.choongang.template.subject;

import org.choongang.template.Template;

public class SubjectUpdateTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("과목 수정\n");
        sb.append("수정할 과목 코드를 입력하세요.\n");

        return sb.toString();
    }
}

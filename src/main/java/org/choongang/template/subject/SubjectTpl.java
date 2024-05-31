package org.choongang.template.subject;

import org.choongang.template.Template;

public class SubjectTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append("과목이름\n");
        sb.append("과목번호\n");
        sb.append("교수이름\n");
        sb.append("강의시간\n");
        sb.append("강의분류(1)\n");
        sb.append("강의분류(2)\n");
        sb.append("학점/시간\n");

        return sb.toString();
    }
}

package org.choongang.template.member;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class JoinTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("회원가입\n");
        sb.append("다음 가입 항목을 입력하세요.\n");
        sb.append(Templates.getInstance().line());
        return sb.toString();
    }
}

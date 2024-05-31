package org.choongang.template.member;

import org.choongang.template.Template;
import org.choongang.template.Templates;

public class LoginTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("로그인\n");
        sb.append("다음 로그인 항목을 입력하세요.\n");
        //sb.append("1. 학생 로그인\n");
        //sb.append("2. 관리자 로그인\n");
        sb.append(Templates.getInstance().line());
        return sb.toString();
    }
}

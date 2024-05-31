package org.choongang.template.main;

import org.choongang.template.Template;

public class MainTpl implements Template {
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(2000);
        sb.append(" 메뉴\n")
                .append("1. 회원가입\n")
                .append("2. 로그인\n")
                .append("------------------");
        return sb.toString();
    }
}

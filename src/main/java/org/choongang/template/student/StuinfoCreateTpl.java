package org.choongang.template.student;

import org.choongang.template.Template;

public class StuinfoCreateTpl implements Template {

    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("학생정보 추가\n");
        sb.append("원하는 학생 정보를 입력하세요\n");

        return sb.toString();
    }
    }



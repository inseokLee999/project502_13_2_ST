package org.choongang.template.student;

import org.choongang.template.Template;

import java.util.function.Supplier;

public class StuinfoReadTpl implements Template {
    private Supplier<String> hook;
    public void addHook(Supplier<String> hook){
        this.hook= hook;
    }
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("학생 정보 조회\n");
        if(hook!=null){
            sb.append(hook.get());
        }
        return sb.toString();
    }
}

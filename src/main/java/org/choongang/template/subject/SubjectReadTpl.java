package org.choongang.template.subject;

import org.choongang.template.Template;

import java.util.function.Supplier;

public class SubjectReadTpl implements Template {
    private Supplier<String> hook;
    public void addHook(Supplier<String> hook){
        this.hook= hook;
    }
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("과목 조회\n");
        if(hook!=null){
            sb.append(hook.get());
        }
        return sb.toString();
    }
}

package org.choongang.template.attend;

import org.choongang.template.Template;

import java.util.function.Supplier;

public class AttendReadTpl implements Template {
    private Supplier<String> hook;
    public void addHook(Supplier<String> hook){
        this.hook= hook;
    }
    @Override
    public String getTpl() {
        StringBuffer sb = new StringBuffer(1000);
        sb.append("출석 조회\n");
        if(hook!=null){
            sb.append(hook.get());
        }
        return sb.toString();
    }
}

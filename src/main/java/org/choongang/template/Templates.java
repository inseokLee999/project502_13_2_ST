package org.choongang.template;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.students.constants.StuInfoMenu;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.template.after_login_menu.*;
import org.choongang.template.main.MainTpl;
import org.choongang.template.member.JoinTpl;
import org.choongang.template.member.LoginTpl;
import org.choongang.template.member.MypageTpl;
import org.choongang.template.student.StuinfoCreateTpl;
import org.choongang.template.student.StuinfoReadTpl;
import org.choongang.template.subject.SubjectCreateTpl;
import org.choongang.template.subject.SubjectDeleteTpl;
import org.choongang.template.subject.SubjectReadTpl;
import org.choongang.template.subject.SubjectUpdateTpl;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Templates {

    private static Templates instance;
    private Map<Menu, Template> tpls;
    private Templates(){
        tpls = new HashMap<>();
    }

    public static Templates getInstance(){
        if(instance == null){
            instance = new Templates();
        }
        return instance;
    }
    public void render(Menu menu){
        render(menu,null);
    }
    public void render(Menu menu,Supplier<String> hook){
        System.out.println(find(menu,hook).getTpl());
    }
    public Template find(Menu menu, Supplier<String> hook){
        Template tpl = tpls.get(menu);
        if(tpl != null){
            return tpl;
        }
        if (menu instanceof MainMenu) {
            MainMenu mainMenu = (MainMenu) menu;
            switch (mainMenu) {
                case JOIN:
                    tpl = new JoinTpl();
                    break;
                case LOGIN:
                    tpl = new LoginTpl();
                    break;
                case MYPAGE:
                    tpl = new MypageTpl();
                    break;
                default:
                    tpl = new MainTpl();
            }
        } else if (menu instanceof SubMenu) {
            SubMenu subMenu = (SubMenu)menu;
            switch (subMenu){
                case ATTENDMANAGER:
                    tpl = new Attend_Manager_Tpl();
                    break;
                case SUBMAIN:
                    tpl = new After_Login_Tpl();
                    break;
                case ATTEND:
                    tpl = new Attend_Tpl();
                    break;
                case PRIVACY:
                    tpl = new Privarcy_Tpl();
                    break;
                case SUBJECT:
                    tpl = new Subject_Imformation_Tpl();
                    break;
            }

        } else if (menu instanceof SubjMenu) {
            SubjMenu subjMenu = (SubjMenu) menu;
            switch (subjMenu){
                case CREATE :
                    tpl = new SubjectCreateTpl();
                    break;
                case READ:
                    tpl = new SubjectReadTpl();
                    break;
                case UPDATE:
                    tpl = new SubjectUpdateTpl();
                    break;
                case DELETE:
                    tpl = new SubjectDeleteTpl();
                    break;
            }
        }else if (menu instanceof StuInfoMenu) {
            StuInfoMenu stuinfoMenu = (StuInfoMenu) menu;
            switch (stuinfoMenu){
                case CREATE :
                    tpl = new StuinfoCreateTpl();
                    break;
                case READ:
                    tpl = new StuinfoReadTpl();
                    break;
                case UPDATE:
                    tpl = new StuinfoCreateTpl();
                    break;
                case DELETE:
                    tpl = new StuinfoCreateTpl();
                    break;
            }
        }




        if(hook!=null){
            tpl.addHook(hook);
        }
        tpls.put(menu,tpl);
        return tpl;
    }
    public String line(){
        return "----------------------------------------\n";
    }
    public String doubleLine(){
        return "========================================\n";
    }
}

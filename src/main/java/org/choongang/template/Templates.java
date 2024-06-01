package org.choongang.template;

import org.choongang.after_login_menu.constants.SubMenu;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;
import org.choongang.template.after_login_menu.After_Login_Tpl;
import org.choongang.template.after_login_menu.Attend_Tpl;
import org.choongang.template.after_login_menu.Privarcy_Tpl;
import org.choongang.template.after_login_menu.Subject_Imformation_Tpl;
import org.choongang.template.main.MainTpl;
import org.choongang.template.member.JoinTpl;
import org.choongang.template.member.LoginTpl;
import org.choongang.template.member.MypageTpl;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println(find(menu).getTpl());
    }

    public Template find(Menu menu){
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
                case SUBMAIN:
                    tpl = new After_Login_Tpl();
                    break;
                case ATTEND:
                    tpl = new Attend_Tpl();
                    break;
                case PRIVARCY:
                    tpl = new Privarcy_Tpl();
                    break;
                case SUBJECT:
                    tpl = new Subject_Imformation_Tpl();
                    break;
            }

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

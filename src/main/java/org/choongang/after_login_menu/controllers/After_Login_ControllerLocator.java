package org.choongang.after_login_menu.controllers;

import org.choongang.after_login_menu.constants.SubMenu;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.member.controllers.JoinController;

public class After_Login_ControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;
    private After_Login_ControllerLocator(){}

    public static ControllerLocator getInstance(){
        if (instance == null){
            instance = new After_Login_ControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }
        //게임 서브 메뉴
        if(menu instanceof SubMenu){
            SubMenu subMenu = (SubMenu) menu;
            switch(subMenu){
                case SUBJECT:
                    controller = new Subject_Imformation_Controller();
                    break;
                case ATTEND:
                    controller = new Attend_Controller();
                    break;
                case PRIVARCY:
                    controller = new Privarcy_Controller();
                    break;
                case SUBMAIN:
                    controller = new After_LoginController();
                    break;

            }
        }else{//선택화면
            controller = new After_LoginController();
        }
        controllers.put(menu,controller);
        return controller;
    }
}
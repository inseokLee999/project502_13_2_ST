package org.choongang.after_login_menu.controllers;

import org.choongang.after_login_menu.constants.SubMenu;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.main.MainRouter;

public class SubRouter implements Router {
    private static Router instance;
    private SubRouter(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new SubRouter();
        }
        return instance;
    }

    @Override
    public void change(Menu menu) {
        ControllerLocator lolocator = After_Login_ControllerLocator.getInstance();

        SubMenu subMenu = (SubMenu) menu;
        Controller controller = null;

        switch (subMenu){
            case SUBJECT: controller = lolocator.find(SubMenu.SUBJECT);break;
            case SUBMAIN: controller = lolocator.find(SubMenu.SUBMAIN);break;
            case ATTEND: controller = lolocator.find(SubMenu.ATTEND);break;
            case PRIVARCY: controller = lolocator.find(SubMenu.PRIVARCY);break;

        }
    }

    @Override
    public void start() {
        while(true){
            change(SubMenu.SUBMAIN);
        }
    }
}

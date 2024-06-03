package org.choongang.AfterLoginMenu.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.attend.controllers.AttendController;
import org.choongang.attend.controllers.Attend_ManagerController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.main.controllers.MainController;

public class AfterLoginControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;
    private AfterLoginControllerLocator(){}

    public static ControllerLocator getInstance(){
        if (instance == null){
            instance = new AfterLoginControllerLocator();
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
                    controller = new SubjectInfoController();
                    break;
                case ATTEND:
                    controller = new AttendController();
                    break;
                case PRIVACY:
                    controller = new PrivacyController();
                    break;
                case SUBMAIN:
                    controller = new AfterLoginController();
                    break;
                case LOGOUT:
                    controller = new MainController();
                    break;
                case ATTENDMANAGER:
                    controller = new Attend_ManagerController();
                    break;
            }
        }
        controllers.put(menu,controller);
        return controller;
    }
}
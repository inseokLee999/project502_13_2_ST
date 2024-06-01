package org.choongang.member.controllers;

import org.choongang.after_login_menu.constants.SubMenu;
import org.choongang.after_login_menu.controllers.After_LoginController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.constants.MainMenu;

import java.util.HashMap;
import java.util.Map;

public class MemberControllerLocator implements ControllerLocator {
    private static ControllerLocator instance;

    private Map<Menu, Controller> controllers;

    private MemberControllerLocator(){
        controllers = new HashMap<>();
    }

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new MemberControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null){
            return controller;
        }

        //switch (subMenu){
         //   case SUBMAIN: controller = new After_LoginController(); break;
        //}
        if(menu instanceof MainMenu){
            MainMenu mainMenu = (MainMenu)menu;
            switch(mainMenu){
                case JOIN : controller = new JoinController(); break;
                default : controller = new LoginController();
            }
        }else if(menu instanceof SubMenu){
            controller = new After_LoginController();

        }
        controllers.put(menu,controller);
        return controller;
    }
}

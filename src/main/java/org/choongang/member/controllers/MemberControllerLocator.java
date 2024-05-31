package org.choongang.member.controllers;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.MainMenu;

import java.util.HashMap;
import java.util.Map;

public class MemberControllerLocator implements ControllerLocator {
    private static ControllerLocator instance;

    private Map<MainMenu, Controller> controllers;

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
    public Controller find(MainMenu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null){
            return controller;
        }
        switch(menu){
            case JOIN : controller = new JoinController(); break;
            default : controller = new LoginController();
        }
        controllers.put(menu,controller);
        return controller;
    }
}

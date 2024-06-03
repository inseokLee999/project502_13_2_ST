package org.choongang.students.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.students.constants.StuInfoMenu;


public class StuinfoControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;
    private StuinfoControllerLocator (){}

    public static ControllerLocator getInstance(){
        if (instance == null){
            instance = new StuinfoControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if (controller != null) {
            return controller;
        }

        //
        if (menu instanceof StuInfoMenu) {
            StuInfoMenu stuinfoMenu = (StuInfoMenu) menu;
            switch (stuinfoMenu) {
                case CREATE:
                    controller = new CreateStuinfoController();
                    break;
                case READ:
                    controller = new ReadStuinfoController();
                    break;
                case UPDATE:
//                    controller = new UpdateStuinfoController();
                    break;
                case DELETE:
//                    controller = new DeleteStuinfoController();
                    break;

            }
        }
        controllers.put(menu, controller);
        return controller;
    }
    }


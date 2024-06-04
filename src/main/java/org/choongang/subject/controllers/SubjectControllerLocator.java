package org.choongang.subject.controllers;

import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.subject.constants.SubjMenu;

public class SubjectControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;
    private SubjectControllerLocator(){}

    public static ControllerLocator getInstance(){
        if (instance == null){
            instance = new SubjectControllerLocator();
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
        if(menu instanceof SubjMenu){
            SubjMenu subjMenu = (SubjMenu) menu;
            switch(subjMenu){
                case CREATE:
                    controller = new CreateSubjectController();
                    break;
                case READ:
                    controller = new ReadSubjectController();
                    break;
                case UPDATE:
                    controller = new UpdateSubjectController();
                    break;
                case DELETE:
                    controller = new DeleteSubjectController();
                    break;

            }
        }
        controllers.put(menu,controller);
        return controller;
    }
}

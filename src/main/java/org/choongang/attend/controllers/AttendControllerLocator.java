package org.choongang.attend.controllers;

import org.choongang.attend.constants.AttendMenu;
import org.choongang.attend.mapper.AttendMapper;
import org.choongang.attend.service.AttendReadService;
import org.choongang.global.*;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.controllers.CreateSubjectController;
import org.choongang.subject.controllers.ReadSubjectController;
import org.choongang.subject.controllers.SubjectControllerLocator;

public class AttendControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;
    private AttendControllerLocator(){}

    public static ControllerLocator getInstance(){
        if (instance == null){
            instance = new AttendControllerLocator();
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
        if(menu instanceof AttendMenu){
            AttendMenu attendMenu = (AttendMenu) menu;
            switch(attendMenu){
                case CREATE:
                    controller = new AttendCreateController();
                    break;
                case READ:
                    controller = new AttendReadController();
                    break;
                case UPDATE:
                   controller = new AttendUpdateController();
                    break;
                case DELETE:
                   controller = new AttendDeleteController();
                    break;

            }
        }
        controllers.put(menu,controller);
        return controller;
    }
}

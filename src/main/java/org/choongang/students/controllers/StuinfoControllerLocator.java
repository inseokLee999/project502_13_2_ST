package org.choongang.students.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.students.constants.StuinfoMenu;
import org.choongang.students.entities.Stuinfo;
import org.choongang.subject.controllers.CreateSubjectController;
import org.choongang.subject.controllers.ReadSubjectController;
import org.choongang.subject.controllers.SubjectControllerLocator;

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
        if(controller != null){
            return controller;
        }

        //
        if(menu instanceof SubMenu){
            StuinfoMenu stuinfoMenu = (StuinfoMenu) menu;
            switch (stuinfoMenu){
                case CREATE:
                    controller = new CreateStuController();
                    break;
                case READ:
                    controller = new ReadSubjectController();
                    break;
                case UPDATE:
//                    controller = new UpdateSubjectController();
                    break;
                case DELETE:
//                    controller = new DeleteSubjectController();
                    break;

            }
        }
        }

    }
}

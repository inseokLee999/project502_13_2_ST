package org.choongang.students.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.students.constants.StuinfoMenu;
import org.choongang.students.entities.StuInfo;
import org.choongang.students.services.StuinfoServiceLocator;

public class CreateStuinfoController extends AbstractController {

    @Override
    public void show() {
        Service<StuInfo> service = StuinfoServiceLocator.getInstance().find(StuinfoMenu.CREATE);
        StuInfo ranks = service.process(); // ranks??

        System.out.println("StuinfoServiceLocator 실행");
    }
}

package org.choongang.students.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.students.constants.StuinfoMenu;
import org.choongang.students.entities.Stuinfo;
import org.choongang.students.services.StuinfoServiceLocator;

public class CreateStuinfoController extends AbstractController {

    @Override
    public void show() {
        Service<Stuinfo> service = StuinfoServiceLocator.getInstance().find(StuinfoMenu.CREATE);
        Stuinfo ranks = service.process(); // ranks??

        System.out.println("StuinfoServiceLocator 실행");
    }
}

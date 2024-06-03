package org.choongang.students.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.students.constants.StuinfoMenu;
import org.choongang.students.entities.Stuinfo;

public class ReadStuinfoController extends AbstractController {
    @Override
    public void show() {
        Service<Stuinfo> service = StuinfoServiceLocator.getInstance().find(StuinfoMenu.READ);
        Stuinfo stuinfo  = service.process(1);
        System.out.println(stuinfo);
        MainRouter.getInstance().change(SubMenu.PRIVACY);
    }
}

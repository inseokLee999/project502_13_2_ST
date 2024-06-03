package org.choongang.students.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.students.constants.StuInfoMenu;
import org.choongang.students.entities.StuInfo;
import org.choongang.students.services.StuinfoServiceLocator;

public class CreateStuinfoController extends AbstractController {

    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        while (true) {
            String subName = promptWithValidation("과목 이름(종료 입력 시 종료) : ", s -> {
                if (s.equals("종료")) {
                    router.change(SubMenu.SUBJECT);
                    return false;
                }
                return !s.isBlank();
            });

        }
    }
}

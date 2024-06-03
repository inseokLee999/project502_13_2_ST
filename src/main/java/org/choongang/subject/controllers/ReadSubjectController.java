package org.choongang.subject.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.services.SubjectServiceLocator;

public class ReadSubjectController extends AbstractController {
    @Override
    public void show() {
        Service<Subject> service = SubjectServiceLocator.getInstance().find(SubjMenu.READ);
        Subject subject  = service.process(1);
        System.out.println(subject);
        MainRouter.getInstance().change(SubMenu.SUBJECT);
    }
}

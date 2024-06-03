package org.choongang.subject.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Service;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.services.SubjectServiceLocator;

import java.util.List;

public class CreateSubjectController extends AbstractController {
    @Override
    public void show() {
        Service<Subject> service = SubjectServiceLocator.getInstance().find(SubjMenu.CREATE);
        Subject ranks = service.process();

        System.out.println("CreateSubjectController 실행");
    }
}

package org.choongang.AfterLoginMenu.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.member.MemberSession;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.controllers.SubjectControllerLocator;
import org.choongang.template.Templates;

public class SubjectInfoController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(SubMenu.SUBJECT);
    }

    @Override
    public void prompt() {
        while (true) {
            System.out.print("메뉴 선택: ");
            String menu = sc.nextLine();
            try {
                int m = Integer.parseInt(menu);
                if (m >= 1 && m <= 5) {
                    change(m);
                    break;
                }else{
                    throw new Exception();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("메뉴 1,2,3,4,5 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo) {
        ControllerLocator locator = SubjectControllerLocator.getInstance();
        ControllerLocator locator1 = AfterLoginControllerLocator.getInstance();
        Controller controller = null;

        switch (menuNo) {
            case 1:
                controller = locator1.find(SubMenu.SUBMAIN); // 수정된 부분: 컨트롤러를 직접 찾음
                break;
            case 2:
                controller = locator.find(SubjMenu.READ);
                break;
        }

        if (MemberSession.isAdmin()) {
            switch (menuNo) {
                case 3:
                    controller = locator.find(SubjMenu.CREATE);
                    break;
                case 4:
                    controller = locator.find(SubjMenu.UPDATE);
                    break;
                case 5:
                    controller = locator.find(SubjMenu.DELETE);
                    break;
                default:
                    controller = locator.find(SubMenu.SUBJECT);
                    break;
            }
        }
        if (controller != null) {
            controller.run();
        }
    }
}
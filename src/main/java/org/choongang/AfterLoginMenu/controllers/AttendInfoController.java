package org.choongang.AfterLoginMenu.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.attend.constants.AttendMenu;
import org.choongang.attend.controllers.AttendControllerLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.controllers.SubjectControllerLocator;
import org.choongang.template.Templates;

public class AttendInfoController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(SubMenu.ATTEND);
    }

    @Override
    public void prompt() {
        while (true) {
            System.out.print("메뉴선택: ");
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
        ControllerLocator locator = AttendControllerLocator.getInstance();
        ControllerLocator locator1 = AfterLoginControllerLocator.getInstance();
        Controller controller = null;
        switch (menuNo) {
            case 1:
                controller = locator1.find(SubMenu.SUBMAIN); // 수정된 부분: 컨트롤러를 직접 찾음
                break;
            case 2:
                controller = locator.find(AttendMenu.CREATE);break;
            case 3:
                controller = locator.find(AttendMenu.READ);break;
            case 4:
                controller = locator.find(AttendMenu.UPDATE);break;
            case 5:
                controller = locator.find(AttendMenu.DELETE);break;
            default:
                controller = locator.find(SubMenu.ATTEND);
                break;
        }

        if (controller != null) {
            controller.run();
        }
    }
}


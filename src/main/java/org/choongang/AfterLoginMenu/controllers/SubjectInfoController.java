package org.choongang.AfterLoginMenu.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
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
                if (m >= 1 && m <= 4) {
                    System.out.println(m);
                    change(m);
                    break;
                }else{
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("메뉴 1,2,3,4 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo) {
        ControllerLocator locator = AfterLoginControllerLocator.getInstance();
        Controller controller = null;
        switch (menuNo) {
            case 1:
                controller = locator.find(SubMenu.SUBMAIN); // 수정된 부분: 컨트롤러를 직접 찾음
                break;
                // 메뉴 구현 필요
            default:
                controller = locator.find(SubMenu.SUBJECT);
                break;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
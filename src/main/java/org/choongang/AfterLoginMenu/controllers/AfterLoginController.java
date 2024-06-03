package org.choongang.AfterLoginMenu.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.MemberSession;
import org.choongang.template.Templates;

public class AfterLoginController extends AbstractController {

    @Override
    public void show() {
        Templates.getInstance().render(SubMenu.SUBMAIN);
    }
    @Override
    public void prompt() {
        while(true) {
            System.out.print("메뉴 선택: ");
            String menu = sc.nextLine();
            try {
                int m = Integer.parseInt(menu);
                if (m >= 0 && m <= 3) {
                    change(m);
                    break;
                }else{
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("메뉴 1,2,3 중에서 선택하세요.");
            }
        }
    }
    private void change(int menuNo) {
        ControllerLocator locator = AfterLoginControllerLocator.getInstance();
        Controller controller = null;
        switch(menuNo) {
            case 0 :
                System.out.println("로그아웃 중..");
                MemberSession.logout();
                controller = locator.find(SubMenu.LOGOUT);break;
            case 1: controller = locator.find(SubMenu.SUBJECT); break;
            case 2: controller = locator.find(SubMenu.ATTENDMANAGER); break;
            case 3: controller = locator.find(SubMenu.PRIVACY); break;
            default:
                MainRouter.getInstance().change(SubMenu.SUBMAIN);
                return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}


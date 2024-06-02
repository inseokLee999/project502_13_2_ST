package org.choongang.after_login_menu.controllers;

import org.choongang.after_login_menu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

public class After_LoginController extends AbstractController {

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
                if (m >= 1 && m <= 3) {
                    System.out.println(m);
                    change(m);
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("메뉴 1,2,3 중에서 선택하세요.");
            }
        }
    }
    private void change(int menuNo) {
        ControllerLocator locator = After_Login_ControllerLocator.getInstance();
        Controller controller = null;
        switch(menuNo) {
            case 1: controller = locator.find(SubMenu.SUBJECT); break;
            case 2: controller = locator.find(SubMenu.ATTEND); break;
            case 3: controller = locator.find(SubMenu.PRIVARCY); break;
            default:
                MainRouter.getInstance().change(SubMenu.SUBMAIN);
                return;
        }

        if (controller != null) {
            controller.run();
        }
    }
}


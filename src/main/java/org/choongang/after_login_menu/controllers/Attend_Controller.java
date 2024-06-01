package org.choongang.after_login_menu.controllers;

import org.choongang.after_login_menu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.template.Templates;

public class Attend_Controller extends AbstractController {
    Router router = SubRouter.getInstance();
    @Override
    public void show() {
        Templates.getInstance().render(SubMenu.ATTEND);
    }
    @Override
    public void prompt() {
        while (true) {
            System.out.print("메뉴 선택: ");
            String menu = sc.nextLine();
            try {
                int m = Integer.parseInt(menu);
                    change(m);
                    break;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("메뉴 1,2,3,4 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo) {
        ControllerLocator locator = After_Login_ControllerLocator.getInstance();
        Controller controller = null;
        switch (menuNo) {
            case 1:
                controller = locator.find(SubMenu.SUBMAIN);
                break;
            default:
                controller = locator.find(SubMenu.SUBJECT);
                break;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
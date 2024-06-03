package org.choongang.main;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.AfterLoginMenu.controllers.AfterLoginControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.global.Router;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.controllers.MainController;
import org.choongang.member.controllers.MemberControllerLocator;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.controllers.SubjectControllerLocator;

public class MainRouter implements Router {
    private static Router instance;
    private MainRouter(){}
    public static Router getInstance(){
        if(instance == null){
            instance = new MainRouter();
        }
        return instance;
    }
    @Override
    public void change(Menu menu) {
        ControllerLocator memLocator = MemberControllerLocator.getInstance();
        ControllerLocator afterLoginLocator = AfterLoginControllerLocator.getInstance();
        ControllerLocator subjectLocator =
                SubjectControllerLocator.getInstance();
        Controller controller = null;
        if(menu instanceof MainMenu) {
            MainMenu mainMenu = (MainMenu) menu;
            switch (mainMenu) {
                case JOIN:
                    controller = memLocator.find(MainMenu.JOIN);
                    break;
                case LOGIN:
                    controller = memLocator.find(MainMenu.LOGIN);
                    break;
                default:
                    controller = new MainController();
            }
        } else if (menu instanceof SubMenu) {
            SubMenu subMenu = (SubMenu) menu;
            switch (subMenu) {
                case SUBJECT:
                    controller = afterLoginLocator.find(SubMenu.SUBJECT);
                    break;
                case SUBMAIN:
                    controller = afterLoginLocator.find(SubMenu.SUBMAIN);
                    break;
                case ATTEND:
                    controller = afterLoginLocator.find(SubMenu.ATTEND);
                    break;
                case PRIVACY:
                    controller = afterLoginLocator.find(SubMenu.PRIVACY);
                    break;
            }
        }else if (menu instanceof SubjMenu){
            SubjMenu subjMenu = (SubjMenu) menu;
            switch (subjMenu){
                case CREATE :
                    controller = subjectLocator.find(SubjMenu.CREATE);
                    break;
                case READ:
                    controller = subjectLocator.find(SubjMenu.READ);
                    break;
                case DELETE:
                    controller = subjectLocator.find(SubjMenu.DELETE);
                    break;
                case UPDATE:
                    controller = subjectLocator.find(SubjMenu.UPDATE);
                    break;
            }
        }
        controller.run();
    }

    @Override
    public void start() {
        while(true){
            change(MainMenu.MAIN);//첫화면은 메인 컨트롤러 출력화면
        }
    }
}

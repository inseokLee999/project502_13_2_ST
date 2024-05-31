package org.choongang.main;

import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.global.constants.Menu;
import org.choongang.main.controllers.MainController;
import org.choongang.member.controllers.MemberControllerLocator;

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
        ControllerLocator memlocator = MemberControllerLocator.getInstance();

        Controller controller = null;
        switch(menu){
            case JOIN: controller = memlocator.find(Menu.JOIN);break;
            case LOGIN: controller = memlocator.find(Menu.LOGIN);break;
            case ATTEND:controller = memlocator.find(Menu.ATTEND);break;
            default: controller = new MainController();

        }
        controller.run();
    }

    @Override
    public void start() {
        while(true){
            change(Menu.MAIN);//첫화면은 메인 컨트롤러 출력화면
        }
    }
}

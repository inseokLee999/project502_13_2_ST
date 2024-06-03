package org.choongang.member.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.*;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.UserSession;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;
/**
 * 로그인 컨트롤러
 */
public class LoginController extends AbstractController {
    Router router = MainRouter.getInstance();
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.LOGIN);
    }

    @Override
    public void prompt() {
        String userId = promptWithValidation("아이디 : ", s -> !s.isBlank());
        String userPw = promptWithValidation("비밀번호 : ",s -> !s.isBlank());
        RequestLogin form = RequestLogin.builder()
                .userId(userId)
                .userPw(userPw)
                .build();
        System.out.println(form);
        try{

            Service service = MemberServiceLocator.getInstance().find(MainMenu.LOGIN);
            service.process(form);
            System.out.println("로그인 성공!");
            UserSession.getInstance().setUserId(userId);
            router.change(SubMenu.SUBMAIN);

        }catch (RuntimeException e){
            System.err.println(e.getMessage());
        }

    }
}

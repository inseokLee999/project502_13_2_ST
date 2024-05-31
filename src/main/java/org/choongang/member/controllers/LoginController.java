package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.Services.MemberServiceLocator;
import org.choongang.template.Templates;
/**
 * 로그인 컨트롤러
 */
public class LoginController extends AbstractController {
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
        //로그인 처리...
        Router router = MainRouter.getInstance();
        try {
            Service service = MemberServiceLocator.getInstance().find(MainMenu.LOGIN);
            service.process(form);
            router.change(MainMenu.MAIN);//로그인 성공시 -> 메인페이지로 이동
        } catch (RuntimeException e){
            System.err.println(e.getMessage());
            router.change(MainMenu.LOGIN);
        }
        //메인화면으로 돌아가기
    }
}

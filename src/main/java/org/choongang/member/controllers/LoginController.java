package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.Menu;
import org.choongang.main.MainRouter;
import org.choongang.member.Services.MemberServiceLocator;
import org.choongang.member.constants.UserType;
import org.choongang.template.Templates;
/**
 * 로그인 컨트롤러
 */
public class LoginController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(Menu.LOGIN);
    }

    @Override
    public void prompt() {

        String type = promptWithValidation("1. 학생, 2. 관리자 선택(1, 2중 선택): ", s -> !s.isBlank());
        String userId = promptWithValidation("아이디 : ", s -> !s.isBlank());
        String userPw = promptWithValidation("비밀번호 : ",s -> !s.isBlank());
        RequestLogin form = RequestLogin.builder()
                    .userId(userId)
                    .userPw(userPw)
                    .userType(type.equals("2") ? UserType.ADMIN : UserType.STUDENT)
                    .build();
            System.out.println(form);
            //로그인 처리...
            Router router = MainRouter.getInstance();
            try {
                Service service = MemberServiceLocator.getInstance().find(Menu.LOGIN);
                service.process(form);
                router.change(Menu.MAIN);//로그인 성공시 -> 메인페이지로 이동
            } catch (RuntimeException e){
                System.err.println(e.getMessage());
                router.change(Menu.LOGIN);
            }
    }

}

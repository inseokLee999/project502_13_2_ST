package org.choongang.member.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.*;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.MemberSession;
import org.choongang.member.constants.UserType;
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
        while(true) {
            String type = promptWithValidation("학생 / 관리자", s -> {
                boolean chk = s.equals("학생") || s.equals("관리자");
                if (!chk) {
                    System.err.println("학생이나 관리자 중에 입력하세요");
                }
                return !s.isBlank();
            });

            break;
        }
        UserType userType = type.equals("1") ? UserType.STUDENT:UserType.ADMIN;
        RequestLogin form = RequestLogin.builder()
                .userId(userId)
                .userPw(userPw)
                .userType()
                .build();
        System.out.println(form);
        try{

            Service service = MemberServiceLocator.getInstance().find(MainMenu.LOGIN);
            service.process(form);
            System.out.println("로그인 성공!");
            MemberSession.getInstance().setUserId(userId);
            router.change(SubMenu.SUBMAIN);

        }catch (RuntimeException e){
            System.err.println(e.getMessage());
        }

    }
}

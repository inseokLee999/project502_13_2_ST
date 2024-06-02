package org.choongang.member.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.*;
import org.choongang.global.constants.MainMenu;
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
        //로그인 처리코드 짜야함
       // Router router = MainRouter.getInstance();
        ControllerLocator lo = MemberControllerLocator.getInstance();
        Controller controller = lo.find(SubMenu.SUBMAIN);

        if(controller != null){
            controller.run();
        }
//        try {
////            Service service = MemberServiceLocator.getInstance().find(MainMenu.LOGIN);
////            service.process(form);
//              router.change(SubMenu.SUBMAIN);//로그인 성공시 -> 메인페이지로 이동
//
//        } catch (RuntimeException e){
//            System.err.println(e.getMessage());
//            router.change(MainMenu.LOGIN);
//        }
        //메인화면으로 돌아가기
    }
}

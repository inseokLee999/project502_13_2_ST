package org.choongang.member.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.constants.UserType;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.template.Templates;

import java.util.Arrays;
import java.util.List;

/**
 * 회원 가입 컨트롤러
 */
public class JoinController extends AbstractController {
    @Override
    public void show() {
        Templates.getInstance().render(MainMenu.JOIN);
    }

    @Override
    public void prompt() {



        while (true) {
            /**
             * 아이디 :
             * 비밀번호 :
             * ...
             */
            String type = promptWithValidation("학생(1), 관리자(2) : ", s -> !s.isBlank() || (!s.equals("1") && s.equals("2")));

            String userId = promptWithValidation("아이디(6자리 이상) : ", s -> s.length() >= 6);
            String userPw = promptWithValidation("비밀번호(8자리 이상) : ", s -> s.length() >= 8);
            String confirmPw = promptWithValidation("비밀번호 확인 : ", s -> {
                boolean match = s.equals(userPw);
                if (!match) System.err.println("\n비밀번호가 일치하지 않습니다.");
                return match;
            });

            String userNm = promptWithValidation("사용자 이름 : ", s -> !s.isBlank());
            if (type.equals("2")) {
                // 관리자에 필요한 항목 추가
                List<String> codes = Arrays.asList("code1", "code2", "code3");
                String verification = promptWithValidation("관리자 승인코드 : ", s -> !s.isBlank());

                if (!codes.contains(verification)) {
                    System.err.println("승인코드가 일치하지 않습니다.");
                    continue;
                }

            }
            UserType userType = type.equals("1") ? UserType.STUDENT:UserType.ADMIN;

                    RequestJoin form = RequestJoin.builder()
                    .userId(userId)
                    .userPw(userPw)
                    .confirmPw(confirmPw)
                    .userNm(userNm)
                    .userType(userType)
                    .build();
            System.out.println(form);
            Router router = MainRouter.getInstance();
            try {
                //회원가입 처리
                Service service = MemberServiceLocator.getInstance().find(MainMenu.JOIN);
                service.process(form);

                //회원가입 성공시 -> 로그인화면 이동
                router.change(MainMenu.LOGIN);
            } catch (RuntimeException e) {
                //회원가입 실패시
                System.err.println(e.getMessage());
                router.change(MainMenu.JOIN);
            }

        }
    }
}
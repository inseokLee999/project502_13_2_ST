package org.choongang.students.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.students.constants.StuInfoMenu;
import org.choongang.students.entities.StuInfo;
import org.choongang.students.services.StuinfoServiceLocator;

import java.util.Date;

public class UpdateStuinfoController extends AbstractController {

    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        //업데이트 코드 구현
        while(true){
            int userNo = 0;
            while (true) {
                String userNoStr = promptWithValidation("수정할 학생의 학번을 입력하세요 (종료 입력 시 종료) : ", s -> {
                    if (s.equals("종료")) {
                        router.change(SubMenu.PRIVACY);
                        return false;
                    }
                    return !s.isBlank();
                });
                try {
                    userNo = Integer.parseInt(userNoStr);
                    break;
                } catch (Exception e) {
                    System.err.println("학번을 숫자로 입력해주세요");
                }
            }
            int grade = Integer.parseInt(promptWithValidation("학년: ", d-> !d.isBlank()));
            String gender = promptWithValidation("성별: ", s-> s.isBlank());
            String semester = promptWithValidation("학기: ", s-> s.isBlank());
            String dept = promptWithValidation("학과: ", s-> s.isBlank());
            int stuCredit = Integer.parseInt(promptWithValidation("학점: ", s-> s.isBlank()));
            String adYr = promptWithValidation("입학년도: ", d-> d.isBlank());
            String eMail = promptWithValidation("이메일: ", s-> s.isBlank());
            int tel = Integer.parseInt(promptWithValidation("전화번호: ", d-> !d.isBlank()));
            StuInfo stuInfo = StuInfo.builder()
                    .grade(grade)
                    .gender(gender)
                    .semester(semester)
                    .dept(dept)
                    .stuCredit(stuCredit)
                    .adYr(adYr)
                    .eMail(eMail)
                    .tel(tel)
                    .build();
            try {
                Service service = StuinfoServiceLocator.getInstance().find(StuInfoMenu.UPDATE);
                service.process(stuInfo);
                System.out.println("학번 수정 완료");
                router.change(StuInfoMenu.UPDATE);
                break;
            } catch (RuntimeException e) {
                System.err.println("학번 수정 실패 : 해당 학생이 존재하지 않습니다.");
                System.out.println();
            }
        }
    }
}

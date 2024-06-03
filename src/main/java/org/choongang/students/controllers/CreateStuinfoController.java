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

public class CreateStuinfoController extends AbstractController {

    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        while (true) {
            String userNo = String.valueOf(promptWithValidation("학생 이름(종료 입력 시 종료) : ", s -> {
                if (s.equals("종료")) {
                    router.change(SubMenu.STUINFO);
                    return false;
                }
                return !s.isBlank();
            }));
            String grade = String.valueOf(promptWithValidation("학년 : ", s -> {
                boolean chksubType = s.equals(1) || s.equals(2) || s.equals(3) ||s.equals(4);
                if (!chksubType) System.err.println("1,2,3,4 중에 입력해주세요");
                return chksubType;
            }));
            String gender = String.valueOf(promptWithValidation("성별 : ", s -> {
                boolean chksubType = s.equals("남") || s.equals("여") ;
                if (!chksubType) System.err.println("남/여 중에 입력해주세요");
                return chksubType;
            }));
            String semester = String.valueOf(promptWithValidation("학기 : ", s -> {
                boolean chksubType = s.equals("1학기") || s.equals("2학기")  || s.equals("계절학기") ;
                if (!chksubType) System.err.println("1학기/2학기/계절학기  중에 입력해주세요");
                return chksubType;
            }));
            String dept = String.valueOf(promptWithValidation("학과:경영학과(1),컴퓨터공학과(2),묵찌빠학과(3) ", s -> !s.isBlank() ||
                    (!s.equals("1") && s.equals("2") && s.equals("3"))));

            String stuCredit = String.valueOf(promptWithValidation("학점 : ", s -> !s.isBlank()));
            Date adYr = promptWithValidation("입학연도 : ", s -> !s.isBlank());
            String eMail = String.valueOf(promptWithValidation("이메일 : ", s -> !s.isBlank()));
            String tel = String.valueOf(promptWithValidation("연락처 : ", s -> !s.isBlank()));

            StuInfo stuInfo = StuInfo.builder()
                    .userNo(Long.parseLong(userNo))
                    .grade(Integer.parseInt(grade))
                    .gender(gender)
                    .semester(semester)
                    .dept(dept)
                    .stuCredit(Integer.parseInt(stuCredit))
                    .adYr(adYr)
                    .eMail(eMail)
                    .tel(Integer.parseInt(tel))
                    .build();
            System.out.println("학생 정보 :" + stuInfo);
            try {
                Service service = StuinfoServiceLocator.getInstance().find(StuInfoMenu.CREATE);
                service.process(stuInfo);
                System.out.println("학생정보 등록 성공");
                router.change(StuInfoMenu.CREATE);
                break;
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.err.println("학생정보 등록 실패");
                System.out.println();
            }
        }
    }
}

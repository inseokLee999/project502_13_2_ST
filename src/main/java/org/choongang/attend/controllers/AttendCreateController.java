package org.choongang.attend.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.attend.constants.AttendMenu;
import org.choongang.attend.entities.Attend;
import org.choongang.attend.service.AttendServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;

public class AttendCreateController extends AbstractController {
    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        while (true) {
            String studentName = promptWithValidation("학생 이름(종료 입력 시 종료) : ", s -> {
                if (s.equals("종료")) {
                    router.change(SubMenu.SUBJECT);
                    return false;
                }
                return !s.isBlank();
            });
            String department = promptWithValidation("학과 : ", s -> !s.isBlank());
            String studentid = promptWithValidation("학번 : ", s -> !s.isBlank());
            String oneweek = promptWithValidation("1주차 : ", s -> !s.isBlank());
            String twoweek = promptWithValidation("2주차 : ", s -> !s.isBlank());
            String threeweek = promptWithValidation("3주차 : ", s -> !s.isBlank());
            String fourweek = promptWithValidation("4주차 : ", s -> !s.isBlank());
            String fiveweek = promptWithValidation("5주차 : ", s -> !s.isBlank());
            String sixweek = promptWithValidation("6주차 : ", s -> !s.isBlank());
            String sevenweek = promptWithValidation("7주차 : ", s -> !s.isBlank());
            Attend attend =Attend.builder()
                    .studentName(studentName)
                    .department(department)
                    .studentId(studentid)
                    .oneWeek(oneweek)
                    .twoWeek(twoweek)
                    .threeWeek(threeweek)
                    .fourWeek(fourweek)
                    .fiveWeek(fiveweek)
                    .sixWeek(sixweek)
                    .sevenWeek(sevenweek)
                    .build();
            try {
                Service service = AttendServiceLocator.getInstance().find(AttendMenu.CREATE);
                service.process(attend);
                System.out.println("학생 출석 등록 성공");
                router.change(AttendMenu.CREATE);
                break;
            }catch (RuntimeException e){
                e.printStackTrace();
                System.out.println("과목 등록실패");
            }
        }
    }
}




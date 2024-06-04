package org.choongang.attend.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.attend.constants.AttendMenu;
import org.choongang.attend.entities.Attend;
import org.choongang.attend.service.AttendServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.services.SubjectServiceLocator;

public class AttendUpdateController extends AbstractController {
    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        //업데이트 코드 구현
        while(true){
            int attendCode = 0;
            while(true) {
                String attendCodeStr = promptWithValidation("수정할 출석코드(종료 입력 시 종료) : ", s -> {
                    if (s.equals("종료")) {
                        router.change(SubMenu.ATTEND);
                        return false;
                    }
                    return !s.isBlank();
                });
                try {
                    attendCode = Integer.parseInt(attendCodeStr);
                    break;
                } catch (Exception e) {
                    System.err.println("출석 코드를 숫자로 입력해주세요");
                }
            }
            String studentName = promptWithValidation("학생이름: ", s -> !s.isBlank());
            String department = promptWithValidation("학과 : ", s -> !s.isBlank());
            String studentId = promptWithValidation("학번 : ", s -> !s.isBlank());
            String oneWeek = promptWithValidation("1주차 : ", s -> !s.isBlank());
            String twoWeek = promptWithValidation("2주차 : ", s -> !s.isBlank());
            String threeWeek = promptWithValidation("3주차 : ", s -> !s.isBlank());
            String fourWeek = promptWithValidation("4주차 : ", s -> !s.isBlank());
            String fiveWeek = promptWithValidation("5주차 : ", s -> !s.isBlank());
            String sixWeek = promptWithValidation("6주차 : ", s -> !s.isBlank());
            String sevenWeek = promptWithValidation("7주차 : ", s -> !s.isBlank());
            Attend attend = Attend.builder()
                    .attendCode(attendCode)
                    .studentName(studentName)
                    .department(department)
                    .studentId(studentId)
                    .oneWeek(oneWeek)
                    .twoWeek(twoWeek)
                    .threeWeek(threeWeek)
                    .fourWeek(fourWeek)
                    .fiveWeek(fiveWeek)
                    .sixWeek(sixWeek)
                    .sevenWeek(sevenWeek)
                    .build();
            try{
                Service service = AttendServiceLocator.getInstance().find(AttendMenu.UPDATE);
                service.process(attend);
                System.out.println("출석 수정 성공");
                router.change(AttendMenu.UPDATE);
                break;
            }catch (RuntimeException e){
                e.printStackTrace();
                System.err.println("출석 수정 실패 : 출석이 존재하지 않습니다.");
                System.out.println();
            }
        }
    }
}
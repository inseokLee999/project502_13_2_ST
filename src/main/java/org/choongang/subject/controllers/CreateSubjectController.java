package org.choongang.subject.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.requests.RequestSubjectInfo;
import org.choongang.subject.services.SubjectServiceLocator;

public class CreateSubjectController extends AbstractController {
    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        while (true) {
            String subName = promptWithValidation("과목 이름(종료 입력 시 종료) : ", s -> {
                if (s.equals("종료")) {
                    router.change(SubMenu.SUBJECT);
                    return false;
                }
                return !s.isBlank();
            });
            String professor = promptWithValidation("교수(님) 이름 : ", s -> !s.isBlank());
            String startTime = promptWithValidation("수업 시작 시간 : ", s -> !s.isBlank());
            String endTime = promptWithValidation("수업 종료 시간 : ", s -> !s.isBlank());
            String subType = promptWithValidation("과목 타입 (전공,교양): ", s -> {
                boolean chksubType = s.equals("전공") || s.equals("교양");
                if (!chksubType) System.err.println("전공/교양 중에 입력해주세요");
                return chksubType;
            });
            String subHour = promptWithValidation("시간 : ", s -> !s.isBlank());
            String subCredit = promptWithValidation("학점 : ", s -> !s.isBlank());
            Subject subject = Subject.builder()
                    .subName(subName)
                    .professor(professor)
                    .startTime(startTime)
                    .endTime(endTime)
                    .subType(subType)
                    .subCredit(Integer.parseInt(subCredit))
                    .subHour(Integer.parseInt(subHour))
                    .build();
            System.out.println("과목 정보 :" + subject);
            try {
                Service service = SubjectServiceLocator.getInstance().find(SubjMenu.CREATE);
                service.process(subject);
                System.out.println("과목 등록 성공");
                router.change(SubjMenu.CREATE);
                break;
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.err.println("과목 등록 실패");
                System.out.println();
            }
        }
    }
}

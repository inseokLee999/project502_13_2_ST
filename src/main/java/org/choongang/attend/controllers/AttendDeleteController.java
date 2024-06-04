package org.choongang.attend.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.attend.constants.AttendMenu;
import org.choongang.attend.service.AttendServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.services.SubjectServiceLocator;

public class AttendDeleteController extends AbstractController {
    @Override
    public void show() {

        Router router = MainRouter.getInstance();
        while(true){
            int attendCode = 0;
            while(true) {
                String attendCodeStr = promptWithValidation("삭제할 학생 번호를 입력하세요 (종료 입력시 종료): ", s -> {
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
                    System.err.println("과목 코드를 숫자로 입력하세요");
                }
            }
            try{
                Service service = AttendServiceLocator.getInstance().find(AttendMenu.DELETE);
                service.process(attendCode);
                System.out.println("출석삭제 성공!");
                router.change(AttendMenu.DELETE);
            }catch (RuntimeException e){
                e.printStackTrace();
                System.err.println("출석삭제 실패ㅠㅠ");
                System.err.println("출석정보가 존재 하지 않습니다.");
                System.out.println();
            }
        }
    }
}


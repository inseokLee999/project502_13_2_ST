package org.choongang.students.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.students.constants.StuInfoMenu;
import org.choongang.students.services.StuinfoServiceLocator;

public class DeleteStuinfoController extends AbstractController {
    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        while (true) {
            int userNo = 0;
            while (true) {
                String userNoStr = promptWithValidation("삭제할 학생의 학번을 입력하세요 (종료 입력시 종료) : ", s -> {
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
                    System.err.println("학번을 숫자로 입력하세요");
                }
            }
            try {
                Service service = StuinfoServiceLocator.getInstance().find(StuInfoMenu.DELETE);
                service.process2(userNo);
                System.out.println("학생 삭제 완료");
                router.change(StuInfoMenu.DELETE);
            } catch (RuntimeException e) {
                System.err.println("학생 삭제 실패");
                System.err.println("학생 정보가 존재하지 않습니다.");
                System.out.println();
            }
        }
    }
}

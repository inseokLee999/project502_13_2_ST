package org.choongang.subject.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.requests.RequestSubjectInfo;
import org.choongang.subject.services.SubjectServiceLocator;

public class DeleteSubjectController extends AbstractController {
    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        while(true){
            int subCode = 0;
            while(true) {
                String subCodeStr = promptWithValidation("삭제할 과목 코드를 입력하세요 (종료 입력시 종료): ", s -> {
                    if (s.equals("종료")) {
                        router.change(SubMenu.SUBJECT);
                        return false;
                    }
                    return !s.isBlank();
                });
                try {
                    subCode = Integer.parseInt(subCodeStr);
                    break;
                } catch (Exception e) {
                    System.err.println("과목 코드를 숫자로 입력하세요");
                }
            }
            try{
                Service service = SubjectServiceLocator.getInstance().find(SubjMenu.DELETE);
                service.process1(subCode);
                System.out.println("과목 삭제 성공!");
                router.change(SubjMenu.DELETE);
            }catch (RuntimeException e){
                System.err.println("과목 삭제 실패ㅠㅠ");
                System.err.println("과목 정보가 존재 하지 않습니다.");
                System.out.println();
            }
        }
    }
}

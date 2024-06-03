package org.choongang.students.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.students.constants.StuinfoMenu;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.services.SubjectServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class ReadStuinfoController extends AbstractController {

    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        while(true) {
            String str = promptWithValidation("과목 코드: ", s -> {
                if(s.equals("종료")){
                    router.change(SubMenu.SUBJECT);
                    return false;
                }
                return !s.isBlank();
            });
            int subCode = Integer.parseInt(str);

            try {

                Service service = SubjectServiceLocator.getInstance().find(StuinfoMenu.READ);
                List subject = service.process(subCode);
                String sub = subject.stream()
                        .map(r->String.format("과목 이름 : %s, 교수 이름 : %s, 수업시작 시간 : %s, 수업종료 시간 :%s, 과목타입 : %s, 시간/학점 : %d/%d",r.getSubName(),r.getProfessor(),r.getStartTime(),r.getEndTime(),r.getSubType(),r.getSubHour(),r.getSubCode())).collect(Collectors.joining("\n"));
                //과목 조회 성공시
                Templates.getInstance().render(SubjMenu.READ,()->sub);
                System.out.println("과목 조회 성공");
                router.change(SubjMenu.READ);
              
                break;
            }catch (RuntimeException e){
                e.printStackTrace();
                System.err.println("과목 조회 실패");
                System.out.println();
                router.change(SubjMenu.READ);
            }
        }
    }
}

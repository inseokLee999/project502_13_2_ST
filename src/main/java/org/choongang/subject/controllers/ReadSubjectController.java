package org.choongang.subject.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.subject.constants.SubjMenu;
import org.choongang.subject.entities.Subject;
import org.choongang.subject.services.SubjectServiceLocator;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class ReadSubjectController extends AbstractController {
    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        while(true) {
            String str = promptWithValidation("읽어올 과목의 코드 (종료 입력 시 종료) : ", s -> {
                if(s.equals("종료")){
                    router.change(SubMenu.SUBJECT);
                    return false;
                }
                return !s.isBlank();
            });
            int subCode = Integer.parseInt(str);

            try {
                Service service = SubjectServiceLocator.getInstance().find(SubjMenu.READ);
                List<Subject> subject = service.process(subCode);
                if(subject == null){
                    throw new RuntimeException();
                }
                String sub = subject.stream()
                        .map(r->String.format("과목 이름 : %s, 교수 이름 : %s, 수업시작 시간 : %s, 수업종료 시간 :%s, 과목타입 : %s, 시간/학점 : %d/%d",r.getSubName(),r.getProfessor(),r.getStartTime(),r.getEndTime(),r.getSubType(),r.getSubHour(),r.getSubCredit())).collect(Collectors.joining("\n"));
                //과목 조회 성공시
                Templates.getInstance().render(SubjMenu.READ,()->sub);
                router.change(SubjMenu.READ);
                break;
            }catch (RuntimeException e){
                System.err.println("과목 조회 실패");
                System.out.println();
                router.change(SubjMenu.READ);
            }
        }
    }
}

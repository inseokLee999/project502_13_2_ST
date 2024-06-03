package org.choongang.attend.controllers;

import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.attend.constants.AttendMenu;
import org.choongang.attend.entities.Attend;
import org.choongang.attend.service.AttendServiceLocator;
import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.main.MainRouter;
import org.choongang.subject.entities.Subject;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class AttendReadController extends AbstractController {
    @Override
    public void show() {
        Router router = MainRouter.getInstance();
        while(true) {
            String str = promptWithValidation("학생이름 (종료 입력 시 종료) : ", s -> {
                if(s.equals("종료")){
                    router.change(SubMenu.ATTEND);
                    return false;
                }
                return !s.isBlank();
            });
            int attendCode = Integer.parseInt(str);

            try {
                Service service = AttendServiceLocator.getInstance().find(AttendMenu.READ);
                List<Attend> attend = service.attendReadProcess(attendCode);
                System.out.println(attend.toString());
                if(attend == null){
                    throw new RuntimeException();
                }
                String atd = attend.stream()
                        .map(r->String.format("학생이름 : %s, 학과 : %s, 학번 : %s, 1주차 :%s, 2주차 : %s, 3주차 : %s,4주차 : %s,5주차 : %s,6주차 : %s,7주차 : %s, ",r.getStudentName(),r.getDepartment(),r.getStudentId(),r.getOneWeek(),r.getTwoWeek(),r.getThreeWeek(),r.getFourWeek(),r.getFiveWeek(),r.getSixWeek(),r.getSevenWeek())).collect(Collectors.joining("\n"));
                //과목 조회 성공시
                Templates.getInstance().render(AttendMenu.READ,()-> atd);
                router.change(AttendMenu.READ);
                break;
            }catch (RuntimeException e){
                e.printStackTrace();
                System.err.println("과목 조회 실패");
                System.out.println();
                router.change(AttendMenu.READ);
            }
        }
    }
}

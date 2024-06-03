package org.choongang.AfterLoginMenu.controllers;

import org.apache.ibatis.session.SqlSession;
import org.choongang.AfterLoginMenu.constants.SubMenu;
import org.choongang.attend.entities.Attend;
import org.choongang.attend.mapper.AttendMapper;
import org.choongang.global.AbstractController;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Router;
import org.choongang.global.configs.DBConn;
import org.choongang.main.MainRouter;
import org.choongang.template.Templates;

import java.util.List;

public class AttendController extends AbstractController {
    Router router = MainRouter.getInstance();
    @Override
    public void show() {
        SqlSession sqlSession = null;
        try{
            sqlSession = DBConn.getSession();
            AttendMapper attendMapper = sqlSession.getMapper(AttendMapper.class);
            List<Attend> attendList = attendMapper.getList();
            for (Attend attend : attendList) {
                System.out.println("Attend Code: " + attend.getAttendCode());
                System.out.println("Student Name: " + attend.getStudentName());
                System.out.println("Department: " + attend.getDepartment());
                System.out.println("Student ID: " + attend.getStudentId());
                System.out.println("One Week: " + attend.getOneWeek());
                System.out.println("Two Week: " + attend.getTwoWeek());
                System.out.println("Three Week: " + attend.getThreeWeek());
                System.out.println("Four Week: " + attend.getFourWeek());
                System.out.println("Five Week: " + attend.getFiveWeek());
                System.out.println("Six Week: " + attend.getSixWeek());
                System.out.println("Seven Week: " + attend.getSevenWeek());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        Templates.getInstance().render(SubMenu.ATTEND);

    }

    @Override
    public void prompt() {
        while (true) {
            System.out.print("메뉴 선택: ");
            String menu = sc.nextLine();
            try {
                int m = Integer.parseInt(menu);
                    change(m);
                    break;
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("메뉴 1,2,3,4 중에서 선택하세요.");
            }
        }
    }

    private void change(int menuNo) {
        ControllerLocator locator = AfterLoginControllerLocator.getInstance();
        Controller controller = null;
        switch (menuNo) {
            case 1:
                controller = locator.find(SubMenu.SUBMAIN);
                break;
            default:
                controller = locator.find(SubMenu.SUBJECT);
                break;
        }

        if (controller != null) {
            controller.run();
        }
    }
}
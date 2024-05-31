package org.choongang.subject.controllers;

import org.choongang.global.AbstractController;

public class SubjectController extends AbstractController {
    @Override
    public void show() {

    }

    @Override
    public void prompt() {

        /*
        sb.append("과목이름\n");
        sb.append("과목번호\n");
        sb.append("교수이름");
        sb.append("강의시간");
        sb.append("강의분류(1)");
        sb.append("강의분류(2)");
        sb.append("학점/시간");

         */
        String subjectNm = promptWithValidation("과목이름:", s -> !s.isBlank());
        String subjectNb = promptWithValidation("과목번호:", s -> !s.isBlank());
        String subjectPn = promptWithValidation("교수이름:", s -> !s.isBlank());
        String subjectTm = promptWithValidation("강의시간:", s -> !s.isBlank());
        String subjectCL1 = promptWithValidation("강의분류1", s -> !s.isBlank());
        String subjectCL2 = promptWithValidation("강의분류2", s -> !s.isBlank());
        String subjectPf = promptWithValidation("학점/시간", s -> !s.isBlank());
    }
}

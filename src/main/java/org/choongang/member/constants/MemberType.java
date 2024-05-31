package org.choongang.member.constants;

import java.util.Arrays;
import java.util.List;

public enum MemberType {

    STUDENT("학생"),
    ADMIN("행정");

    private final String title;

    MemberType(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }

    public static List<String[]> getList() {
        return Arrays.asList(
                new String[] {STUDENT.name(), STUDENT.title()},
                new String[] {ADMIN.name(), ADMIN.title()}
                );
    }
}


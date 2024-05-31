package org.choongang.member.mapper;
//추후 수정 필요  ;경미
import org.choongang.member.controllers.SearchMember;
import org.choongang.member.entities.Member;

import java.util.List;

public interface MemberMapper {
    List<Member> getList(SearchMember search);
    Member get(String userId);
    long getTotal(SearchMember search);
    int exist(String userId);
    int register(Member member);
    int modify(Member member);
    int delete(String userId);
}

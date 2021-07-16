package myapp.myapp.domain.member.repository;

import myapp.myapp.domain.member.Member;

public interface MemberRepositoryCustom {

    Member findMemberById(Long id);
    Member findMemberByEmail(String email);

}
package myapp.myapp.domain.member.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.member.Member;

import static myapp.myapp.domain.member.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public Member findMemberById(Long id) {
        return queryFactory.selectFrom(member)
                .where(
                        member.id.eq(id)
                ).fetchOne();
    }

}
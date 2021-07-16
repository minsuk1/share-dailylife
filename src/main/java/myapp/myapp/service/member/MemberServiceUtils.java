package myapp.myapp.service.member;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.member.Member;
import myapp.myapp.domain.member.MemberRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberServiceUtils {


    public static Member findMemberById(MemberRepository memberRepository, Long memberId) {
        Member member = memberRepository.findMemberById(memberId);
        if (member == null) {
            throw new IllegalArgumentException(String.format("해당 하는 회원 (%s) 은 없습니다", memberId));
        }
        return member;
    }

    public static Member findMemberByEmail(MemberRepository memberRepository, String email) {
        Member member = memberRepository.findMemberByEmail(email);
        if (member == null) {
            throw new IllegalArgumentException(String.format("해당 하는 회원 (%s) 은 없습니다"));
        }
        return member;
    }


}
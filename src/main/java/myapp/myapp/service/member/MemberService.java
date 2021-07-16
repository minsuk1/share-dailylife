package myapp.myapp.service.member;


import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.member.Member;
import myapp.myapp.domain.member.MemberRepository;
import myapp.myapp.service.member.dto.request.UpdateMemberInfoRequest;
import myapp.myapp.service.member.dto.response.MemberInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public MemberInfoResponse getMemberInfo(String name) {
        Member member = MemberServiceUtils.findMemberByEmail(memberRepository, name);
        return MemberInfoResponse.of(member);
    }

//    public MemberInfoResponse updateMemberInfo(UpdateMemberInfoRequest request, String name) {
//        Member member = MemberServiceUtils.findMemberByEmail(memberRepository, name);
//        member.updateMemberInfo(request.getName(), request.getProfileUrl());
//        return MemberInfoResponse.of(member);
//    }

}
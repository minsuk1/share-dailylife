package myapp.myapp.controller.member;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import myapp.myapp.config.auth.LoginUser;
import myapp.myapp.config.auth.dto.SessionUser;
import myapp.myapp.controller.ApiResponse;
import myapp.myapp.service.member.MemberService;
import myapp.myapp.service.member.dto.request.UpdateMemberInfoRequest;
import myapp.myapp.service.member.dto.response.MemberInfoResponse;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Api(tags = {"사용자 API"})
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/api/v1/member")
    @ApiOperation(value  = "사용자 정보 조회 API")
    public ApiResponse<MemberInfoResponse> getMyMemberInfo(@LoginUser SessionUser user) {
        return ApiResponse.of(memberService.getMemberInfo(user.getEmail()));
    }

//    @PatchMapping("/api/v1/member")
//    @ApiOperation(value  = "사용자 정보 수정 API")
//    public ApiResponse<MemberInfoResponse> updateMemberInfo(@Valid @RequestBody UpdateMemberInfoRequest request, @LoginUser SessionUser user) {
//        return ApiResponse.of(memberService.updateMemberInfo(request, user.getEmail()));
//    }

}
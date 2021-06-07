package myapp.myapp.config.auth;

import lombok.RequiredArgsConstructor;
import myapp.myapp.config.auth.dto.OAuthAttributes;
import myapp.myapp.config.auth.dto.SessionUser;

import myapp.myapp.domain.member.Member;
import myapp.myapp.domain.member.MemberRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

// OAuth2User 로그인 성공시 받는 User 데이터
// OAuth2UserService: UserInfo 엔드포인트에서 리소스 소유자 속성 가져옴.
// Oauth2User: Oauth 2.0 Provider로 인증 마치면 OAuth2User.getAuthorities()
// OAuth2UserRequest: OAuth2AccessToken에 접근 가능.
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // google
        String registrationId = userRequest.getClientRegistration().
                getRegistrationId();
        //sub
        String userNameAttributeName = userRequest.getClientRegistration().
                getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        // {sub=114624539647794169021, name=���μ�, email=palt12301@gmail.com}
        // oAuth2User.getAttributes: 소유자 정보 가져오기
        System.out.println(registrationId); // google, naver
        System.out.println(userNameAttributeName); // sub, response
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Member member = saveOrUpdate(attributes);

        httpSession.setAttribute("user", new SessionUser(member));
        System.out.println(attributes.getNameAttributeKey());
        System.out.println("--------------------------------");
        System.out.println(member.getRoleKey());
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey()); //sub
    }


    private Member saveOrUpdate(OAuthAttributes attributes) {
        Member member = memberRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return memberRepository.save(member);
    }
}
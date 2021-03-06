package myapp.myapp.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.BaseTimeEntity;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,  mappedBy = "member")
//    private List<Board> boards;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
//    private List<BoardLike> boardLikes;

    @Builder
    public Member(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public Member update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

//    public void updateMemberInfo(String name, String picture) {
//        if (StringUtils.hasText(name)) {
//            this.name = name;
//        }
//        if (StringUtils.hasText(picture)) {
//            this.picture = picture;
//        }
//    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
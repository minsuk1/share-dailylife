package myapp.myapp.domain.comment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.BaseTimeEntity;
import myapp.myapp.domain.member.Member;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long boardId;

    private Long memberId;

    private String content;

    private boolean isDeleted;

    private Comment(Long boardId, Long memberId, String content) {
        this.boardId = boardId;
        this.memberId = memberId;
        this.content = content;
        this.isDeleted = false;
    }

    public static Comment newInstance(Long boardId, Long memberId, String content) {
        return new Comment(boardId, memberId, content);
    }

    public void delete() {
        this.isDeleted = true;
    }

}
package myapp.myapp.service.comment.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.comment.Comment;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    private Long boardId;
    private String content;

    public Comment toEntity(Long memberId){
        return Comment.newInstance(boardId,memberId,content);
    }
}

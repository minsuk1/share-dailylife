package myapp.myapp.service.comment.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.comment.Comment;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentInfoResponse {

    private final Long commentId;

    private final Long boardId;

    private final Long memberId;

    private final String content;

    public static CommentInfoResponse of(Comment boardComment) {
        return new CommentInfoResponse(boardComment.getId(), boardComment.getBoardId(), boardComment.getMemberId(), boardComment.getContent());
    }

}
package myapp.myapp.service.board.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.board.Board;
import myapp.myapp.domain.comment.Comment;
import myapp.myapp.domain.member.Member;
import myapp.myapp.service.comment.dto.response.CommentInfoResponse;
import myapp.myapp.service.member.dto.response.MemberInfoResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardWithCommentInfoResponse {

    private final BoardInfoResponse board;

    private final MemberInfoResponse creator;

    private final List<CommentInfoResponse> comments = new ArrayList<>();

    public static BoardWithCommentInfoResponse of(Board board, List<Comment> boardCommentList, Member member) {
        List<CommentInfoResponse> commentInfoResponses = boardCommentList.stream()
                .map(CommentInfoResponse::of)
                .collect(Collectors.toList());
        BoardWithCommentInfoResponse response = new BoardWithCommentInfoResponse(BoardInfoResponse.of(board), MemberInfoResponse.of(member));
        response.comments.addAll(commentInfoResponses);
        return response;
    }

}
package myapp.myapp.domain.comment.repository;

import myapp.myapp.domain.comment.Comment;

import java.util.List;

public interface CommentRepositoryCustom {

    Comment findCommentByIdAndMemberId(Long commentId, Long memberId);

    List<Comment> findAllBoardCommentsByBoardId(Long boardId);

}
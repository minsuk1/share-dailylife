package myapp.myapp.service.comment;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.board.Board;
import myapp.myapp.domain.board.BoardRepository;
import myapp.myapp.domain.comment.Comment;
import myapp.myapp.domain.comment.CommentRepository;
import myapp.myapp.exception.ErrorCode;
import myapp.myapp.exception.NotFoundApiException;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentServiceUtils {


    public static Comment findCommentByIdAndMemberId(CommentRepository commentRepository, Long commentId, Long memberId){
         Comment comment = commentRepository.findCommentByIdAndMemberId(commentId, memberId);

         if (comment == null){
             new NotFoundApiException(ErrorCode.NOT_FOUND);
         }

         return comment;

    }

    public static List<Comment> findAllBoardCommentsByCommentId(CommentRepository commentRepository, Long boardId) {
        return commentRepository.findAllBoardCommentsByBoardId(boardId);
    }
}

package myapp.myapp.domain.comment.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.comment.Comment;

import java.util.List;

import static myapp.myapp.domain.comment.QComment.comment;

@RequiredArgsConstructor
public class CommentRepositoryCustomImpl implements CommentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Comment findCommentByIdAndMemberId(Long commentId, Long memberId) {
        return queryFactory.selectFrom(comment)
                .where(
                        comment.id.eq(commentId),
                        comment.isDeleted.isFalse()
                ).fetchOne();
    }

    @Override
    public List<Comment> findAllBoardCommentsByBoardId(Long boardId) {
        return queryFactory.selectFrom(comment)
                .where(
                        comment.boardId.eq(boardId),
                        comment.isDeleted.isFalse()
                ).fetch();
    }

}
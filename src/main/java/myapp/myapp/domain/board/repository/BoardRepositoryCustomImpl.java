package myapp.myapp.domain.board.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.board.Board;

import java.util.List;


import static myapp.myapp.domain.board.QBoard.board;
import static myapp.myapp.domain.board.QBoardPicture.boardPicture;

@RequiredArgsConstructor
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Board> findBoardsOrderByIdDesc(int size) {
        return queryFactory.selectFrom(board)
                .innerJoin(board.pictureList, boardPicture).fetchJoin()
                .orderBy(board.id.desc())
                .limit(size)
                .fetch();
    }

    @Override
    public List<Board> findBoardsLessThanOrderByIdDescLimit(Long lastBoardId, int size) {
        return queryFactory.selectFrom(board)
                .innerJoin(board.pictureList, boardPicture).fetchJoin()
                .where(
                        board.id.lt(lastBoardId)
                )
                .orderBy(board.id.desc())
                .limit(size)
                .fetch();
    }

    @Override
    public Board findBoardById(Long boardId) {
        return queryFactory.selectFrom(board)
                .innerJoin(board.pictureList, boardPicture).fetchJoin()
                .where(
                        board.id.eq(boardId)
                ).fetchOne();
    }

}
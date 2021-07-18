package myapp.myapp.domain.board.repository;

import myapp.myapp.domain.board.Board;

import java.util.List;

public interface BoardRepositoryCustom {

    List<Board> findBoardsOrderByIdDesc(int size);

    List<Board> findBoardsLessThanOrderByIdDescLimit(Long lastBoardId, int size);

    Board findBoardById(Long boardId);

    List<Board> findBoardByMemberId(Long memberId);

}
package myapp.myapp.service.board;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.board.Board;
import myapp.myapp.domain.board.BoardRepository;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class BoardServiceUtils {


    // Querydsl이 아닌 dataJPA 사용
    static Board findBoardById(BoardRepository boardRepository, Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음"+boardId));
        return board;
    }

}
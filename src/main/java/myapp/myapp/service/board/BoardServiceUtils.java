package myapp.myapp.service.board;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.board.Board;
import myapp.myapp.domain.board.BoardRepository;
import myapp.myapp.exception.ErrorCode;
import myapp.myapp.exception.NotFoundApiException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class BoardServiceUtils {


    // Querydsl이 아닌 dataJPA 사용
    static Board findBoardById(BoardRepository boardRepository, Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new NotFoundApiException(ErrorCode.NOT_FOUND));
        return board;
    }

}
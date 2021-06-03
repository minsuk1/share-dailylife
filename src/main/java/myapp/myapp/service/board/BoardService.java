package myapp.myapp.service.board;

import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.board.Board;
import myapp.myapp.domain.board.BoardRepository;
import myapp.myapp.domain.member.Member;
import myapp.myapp.domain.member.MemberRepository;
import myapp.myapp.service.board.dto.request.CreateBoardRequest;
import myapp.myapp.service.board.dto.response.BoardInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public BoardInfoResponse createBoard(CreateBoardRequest request, String name) {
        Member member = memberRepository.findByEmail(name)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
        Board board = boardRepository.save(request.toEntity(member.getId()));
        return BoardInfoResponse.of(board);
    }

    @Transactional(readOnly = true)
    public List<BoardInfoResponse> retrieveBoardList(Long lastBoardId, int size) {
        return lastBoardId == 0 ? getLatestBoards(size) : getLatestBoardLessThanId(lastBoardId, size);
    }

    private List<BoardInfoResponse> getLatestBoards(int size) {
        List<Board> boardList = boardRepository.findBoardsOrderByIdDesc(size);
        return boardList.stream()
                .map(BoardInfoResponse::of)
                .collect(Collectors.toList());
    }

    private List<BoardInfoResponse> getLatestBoardLessThanId(Long lastBoardId, int size) {
        List<Board> boardList = boardRepository.findBoardsLessThanOrderByIdDescLimit(lastBoardId, size);
        return boardList.stream()
                .map(BoardInfoResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoardInfoResponse retrieveBoard(Long boardId) {
        Board board = BoardServiceUtils.findBoardById(boardRepository, boardId);
        return BoardInfoResponse.of(board);
    }

    @Transactional
    public void addBoardLike(Long boardId, String name) {
        Member member = memberRepository.findByEmail(name)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
        Board board = BoardServiceUtils.findBoardById(boardRepository, boardId);
        board.addLike(member.getId());
    }

    @Transactional
    public void cancelBoardLike(Long boardId, String name) {
        Member member = memberRepository.findByEmail(name)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
        Board board = BoardServiceUtils.findBoardById(boardRepository, boardId);
        board.cancelLike(member.getId());
    }
}
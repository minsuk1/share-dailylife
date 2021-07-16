package myapp.myapp.service.board;

import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.board.Board;
import myapp.myapp.domain.board.BoardMemberCollection;
import myapp.myapp.domain.board.BoardRepository;
import myapp.myapp.domain.comment.Comment;
import myapp.myapp.domain.comment.CommentRepository;
import myapp.myapp.domain.member.Member;
import myapp.myapp.domain.member.MemberRepository;
import myapp.myapp.service.board.dto.request.CreateBoardRequest;
import myapp.myapp.service.board.dto.response.BoardInfoResponse;
import myapp.myapp.service.board.dto.response.BoardWithCommentInfoResponse;
import myapp.myapp.service.board.dto.response.BoardWithCreatorInfoResponse;
import myapp.myapp.service.comment.CommentServiceUtils;
import myapp.myapp.service.member.MemberServiceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;


    @Transactional
    public BoardInfoResponse createBoard(CreateBoardRequest request, String name) {
        Member member = memberRepository.findByEmail(name)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));
        Board board = boardRepository.save(request.toEntity(member.getId()));
        return BoardInfoResponse.of(board);
    }

    @Transactional(readOnly = true)
    public List<BoardWithCreatorInfoResponse> retrieveBoardList(Long lastBoardId, int size) {
        return lastBoardId == 0 ? getLatestBoards(size) : getLatestBoardLessThanId(lastBoardId, size);
    }

    private List<BoardWithCreatorInfoResponse> getLatestBoards(int size) {
        List<Board> boardList = boardRepository.findBoardsOrderByIdDesc(size);
        BoardMemberCollection collection = BoardMemberCollection.of(memberRepository, boardList);
        return boardList.stream()
                .map(board -> BoardWithCreatorInfoResponse.of(board, collection.getMember(board.getMemberId())))
                .collect(Collectors.toList());
    }

    private List<BoardWithCreatorInfoResponse> getLatestBoardLessThanId(Long lastBoardId, int size) {
        List<Board> boardList = boardRepository.findBoardsLessThanOrderByIdDescLimit(lastBoardId, size);
        BoardMemberCollection collection = BoardMemberCollection.of(memberRepository, boardList);
        return boardList.stream()
                .map(board -> BoardWithCreatorInfoResponse.of(board, collection.getMember(board.getMemberId())))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoardWithCommentInfoResponse retrieveBoard(Long boardId) {
        Board board = BoardServiceUtils.findBoardById(boardRepository, boardId);
        Member member = MemberServiceUtils.findMemberById(memberRepository, board.getMemberId());
        List<Comment> boardCommentList = CommentServiceUtils.findAllBoardCommentsByCommentId(commentRepository, board.getId());
        return BoardWithCommentInfoResponse.of(board, boardCommentList, member);
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
package myapp.myapp.controller.board;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import myapp.myapp.config.auth.LoginUser;
import myapp.myapp.config.auth.dto.SessionUser;
import myapp.myapp.controller.ApiResponse;
import myapp.myapp.service.board.BoardService;
import myapp.myapp.service.board.dto.request.CreateBoardRequest;
import myapp.myapp.service.board.dto.response.BoardInfoResponse;
import myapp.myapp.service.board.dto.response.BoardWithCommentInfoResponse;
import myapp.myapp.service.board.dto.response.BoardWithCreatorInfoResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Api(tags = {"게시글 조회 API"})
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    @ApiOperation(value  = "피드 저장 API")
    public ApiResponse<BoardInfoResponse> createBoard(@Valid @RequestBody CreateBoardRequest request, @LoginUser SessionUser user) {
        return ApiResponse.of(boardService.createBoard(request, user.getEmail()));
    }

    @GetMapping("/api/v1/board/list")
    @ApiOperation(value  = "특정 피드 조회 API")
    public ApiResponse<List<BoardWithCreatorInfoResponse>> retrieveBoardList(@RequestParam long lastBoardId, @RequestParam int size) {
        return ApiResponse.of(boardService.retrieveBoardList(lastBoardId, size));
    }

    @ApiOperation(value  = "전체 피드 조회 API")
    @GetMapping("/api/v1/board")
    public ApiResponse<BoardWithCommentInfoResponse> retrieveBoard(@RequestParam Long boardId) {
        return ApiResponse.of(boardService.retrieveBoard(boardId));
    }

    @GetMapping("/api/v1/board2")
    @ApiOperation(value  = "전체 피드 조회 API")
    public ApiResponse<BoardInfoResponse> retrieveBoard2(@RequestParam Long boardId) {
        return ApiResponse.of(boardService.OldtrieveBoard(boardId));
    }

    @PostMapping("/api/v1/board/like/{boardId}")
    @ApiOperation(value = "피드 좋아요 추가 API")
    public ApiResponse<String> addBoardLike(@PathVariable Long boardId, @LoginUser SessionUser user) {
        boardService.addBoardLike(boardId, user.getEmail());
        return ApiResponse.OK;
    }

    @DeleteMapping("/api/v1/board/like/{boardId}")
    @ApiOperation(value = "피드 좋아요 취소 API")
    public ApiResponse<String> cancelBoardLike(@PathVariable Long boardId, @LoginUser SessionUser user) {
        boardService.cancelBoardLike(boardId, user.getEmail());
        return ApiResponse.OK;
    }

}
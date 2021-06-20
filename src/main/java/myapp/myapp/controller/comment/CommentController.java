package myapp.myapp.controller.comment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import myapp.myapp.config.auth.LoginUser;
import myapp.myapp.config.auth.dto.SessionUser;
import myapp.myapp.controller.ApiResponse;
import myapp.myapp.service.board.dto.request.CreateBoardRequest;
import myapp.myapp.service.comment.CommentService;
import myapp.myapp.service.comment.dto.request.CreateCommentRequest;
import myapp.myapp.service.comment.dto.response.CommentInfoResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Api(tags = {"댓글 API"})
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value  = "댓글 쓰기 API")
    @PostMapping("/api/v1/board/comment")
    public ApiResponse<CommentInfoResponse> addBoardComment(
            @Valid @RequestBody CreateCommentRequest request, @LoginUser SessionUser user
    ) {
        return ApiResponse.of(commentService.createComment(request, user.getEmail()));
    }

    @ApiOperation(value  = "댓글 삭제 API")
    @DeleteMapping("/api/v1/board/comment")
    public ApiResponse<String> deleteBoardComment(
            @RequestParam Long commentId, @LoginUser SessionUser user) {
        commentService.deleteComment(commentId, user.getEmail());
        return ApiResponse.OK;
    }
}
package myapp.myapp.controller.comment;

import lombok.RequiredArgsConstructor;
import myapp.myapp.config.auth.LoginUser;
import myapp.myapp.config.auth.dto.SessionUser;
import myapp.myapp.controller.ApiResponse;
import myapp.myapp.service.comment.CommentService;
import myapp.myapp.service.comment.dto.request.CreateCommentRequest;
import myapp.myapp.service.comment.dto.response.CommentInfoResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;


}
package myapp.myapp.service.comment;

import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.comment.Comment;
import myapp.myapp.domain.comment.CommentRepository;
import myapp.myapp.service.comment.dto.request.CreateCommentRequest;
import myapp.myapp.service.comment.dto.response.CommentInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional
    public CommentInfoResponse createComment(CreateCommentRequest request, Long memberId){
        Comment comment = commentRepository.save(request.toEntity(memberId));
        return CommentInfoResponse.of(comment);
    }

    @Transactional
    public void deleteComment(Long commentId, Long memberId) {
        Comment comment = CommentServiceUtils.findCommentByIdAndMemberId(commentRepository, commentId, memberId);
        comment.delete();
    }
}

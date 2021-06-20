package myapp.myapp.service.comment;

import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.comment.Comment;
import myapp.myapp.domain.comment.CommentRepository;
import myapp.myapp.domain.member.Member;
import myapp.myapp.domain.member.MemberRepository;
import myapp.myapp.service.comment.dto.request.CreateCommentRequest;
import myapp.myapp.service.comment.dto.response.CommentInfoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentInfoResponse createComment(CreateCommentRequest request, String name){
        Member member = memberRepository.findByEmail(name)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));

        Comment comment = commentRepository.save(request.toEntity(member.getId()));
        return CommentInfoResponse.of(comment);
    }

    @Transactional
    public void deleteComment(Long commentId, String name) {
        Member member = memberRepository.findByEmail(name)
                .orElseThrow(() -> new IllegalArgumentException("사용자 없음"));

        Comment comment = CommentServiceUtils.findCommentByIdAndMemberId(commentRepository, commentId, member.getId());
        comment.delete();
    }
}

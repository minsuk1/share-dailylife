package myapp.myapp.domain.comment;

import myapp.myapp.domain.comment.repository.CommentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {

}
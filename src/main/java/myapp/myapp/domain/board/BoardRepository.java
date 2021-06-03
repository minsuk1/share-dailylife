package myapp.myapp.domain.board;

import myapp.myapp.domain.board.repository.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardRepositoryCustom {

}


// 참고: https://jojoldu.tistory.com/372
// https://docs.spring.io/spring-data/jpa/docs/2.1.3.RELEASE/reference/html/#repositories.custom-implementations

// customRepository를 JpaRepository 상속 클래스에서 상속 가능
// BoardRepository에서 BoardRepositoryCustom, JpaRepository extends
// BoardRepositoryCustomImpl에서 BoardRepositoryCustom implements
// BoardRepository에서 BoardRepositoryCustomImpl사용 가능
package myapp.myapp.domain.board;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.BaseTimeEntity;
import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BoardPicture extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    private String pictureUrl;

    private BoardPicture(Board board, String pictureUrl) {
        this.board = board;
        this.pictureUrl = pictureUrl;
    }

    public static BoardPicture of(Board board, String pictureUrl) {
        return new BoardPicture(board, pictureUrl);
    }

}
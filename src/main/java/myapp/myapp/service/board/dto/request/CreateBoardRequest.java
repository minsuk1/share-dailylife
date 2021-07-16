package myapp.myapp.service.board.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import myapp.myapp.domain.board.Board;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateBoardRequest {

    private String title;

    private String description;

    private List<String> pictures;

    public Board toEntity(Long memberId) {
        Board board = Board.newInstance(memberId, title, description);
        board.addPictures(pictures);
        System.out.println(board);
        System.out.println(pictures);
        return board;
    }

}
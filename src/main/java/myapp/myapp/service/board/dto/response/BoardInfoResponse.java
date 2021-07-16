package myapp.myapp.service.board.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import myapp.myapp.domain.board.Board;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardInfoResponse {

    private final Long id;

    private final String title;

    private final String description;

    private final List<String> pictureUrls = new ArrayList<>();

    public static BoardInfoResponse of(Board board) {
        BoardInfoResponse response = new BoardInfoResponse(board.getId(), board.getTitle(), board.getDescription());
        response.pictureUrls.addAll(board.getPictures());
        //System.out.println(board.getPictures());
        return response;
    }

}
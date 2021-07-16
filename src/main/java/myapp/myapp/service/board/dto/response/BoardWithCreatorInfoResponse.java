package myapp.myapp.service.board.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import myapp.myapp.domain.board.Board;
import myapp.myapp.domain.member.Member;
import myapp.myapp.service.member.dto.response.MemberInfoResponse;

import static lombok.AccessLevel.PRIVATE;

@ToString
@Getter
@RequiredArgsConstructor(access = PRIVATE)
public class BoardWithCreatorInfoResponse {

    private final BoardInfoResponse board;

    private final MemberInfoResponse creator;

    public static BoardWithCreatorInfoResponse of(Board board, Member member) {
        return new BoardWithCreatorInfoResponse(BoardInfoResponse.of(board), MemberInfoResponse.of(member));
    }

}
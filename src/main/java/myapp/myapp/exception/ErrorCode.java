package myapp.myapp.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // global error
    INVALID_INPUT_VALUE(400,"01", "유효하지 않은 값입니다."),
    INVALID_TYPE_VALUE(400,"02", "유효하지 않은 타입입니다."),
    METHOD_NOT_ALLOWED(400,"03", "지원하지 않는 메서드입니다."),
    INTERNAL_SERVER_ERROR(400,"04", "서버 없음."),

    HANDLE_ACCESS_DENIED(401,"05", "권한 없음."),

    // not found
    NOT_FOUND(400,"05", "사용자 없음");


    private final Integer status;
    private final String code;
    private final String message;
}
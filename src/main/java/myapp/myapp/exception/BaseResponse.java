package myapp.myapp.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public abstract class BaseResponse {

    private final Meta meta;

    protected BaseResponse(Integer status, String code, String message) {
        this.meta = new Meta(status, code, message);
    }

    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    private static class Meta {

        private final Integer status;
        private final String code;
        private final String message;
    }
}
package myapp.myapp.exception;

public class BadRequestApiException extends RuntimeException {

    public BadRequestApiException(ErrorCode errorCode) {
        super(errorCode.name());
    }
}
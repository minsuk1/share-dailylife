package myapp.myapp.exception;

public class NotFoundApiException extends RuntimeException {

    public NotFoundApiException(ErrorCode errorCode) {
        super(errorCode.name());
    }
}
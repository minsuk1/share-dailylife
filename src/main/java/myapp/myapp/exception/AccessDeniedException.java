package myapp.myapp.exception;

public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(ErrorCode errorCode) {
        super(errorCode.name());
    }
}
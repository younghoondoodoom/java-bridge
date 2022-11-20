package bridge.exception;

public enum ErrorCode {

    INVALID_SIZE("적절하지 않은 크기입니다."),
    INVALID_SIGNATURE_NUMBER("적절하지 않은 숫자 입니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

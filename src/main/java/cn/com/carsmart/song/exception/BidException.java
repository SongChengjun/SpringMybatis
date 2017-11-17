package cn.com.carsmart.song.exception;

public class BidException extends Exception {

    private Long errorCode;

    public BidException(String message) {
        super(message);
    }

    public BidException(Long errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public Long getErrorCode() {
        return errorCode;
    }
}

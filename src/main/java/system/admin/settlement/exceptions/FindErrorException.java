package system.admin.settlement.exceptions;

public class FindErrorException extends RuntimeException {

    public FindErrorException(Throwable cause) {
        super(cause);
        this.getMessage();
    }

    @Override
    public String getMessage() {
        return "조회 실패";
    }
}

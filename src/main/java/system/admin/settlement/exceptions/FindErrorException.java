package system.admin.settlement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
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

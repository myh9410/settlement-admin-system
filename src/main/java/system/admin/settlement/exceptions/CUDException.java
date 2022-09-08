package system.admin.settlement.exceptions;

import org.springframework.http.HttpMethod;

public class CUDException extends RuntimeException {

    public CUDException(HttpMethod method, Throwable cause) {
        super(cause);
        this.getMessage(method);
    }

    public String getMessage(HttpMethod method) {
        return method.toString() + " - 동작 실패";
    }
}

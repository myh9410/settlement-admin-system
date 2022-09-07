package system.admin.settlement.exceptions;

import org.springframework.http.HttpMethod;

public class SaveErrorException extends RuntimeException {

    public SaveErrorException(HttpMethod method, Throwable cause) {
        super(cause);
        this.getMessage(method);
    }

    public String getMessage(HttpMethod method) {
        return method.toString() + " - 동작 실패";
    }
}

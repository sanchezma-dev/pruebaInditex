package app.inditex.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class ApiResponseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;

    public ApiResponseException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public static ApiResponseException of(final String message, final HttpStatus httpStatus) {
        return new ApiResponseException(message, httpStatus);
    }
}

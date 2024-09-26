package app.inditex.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ApiResponseException.class})
    public ResponseEntity<Object> handleApiResponseException(ApiResponseException ex) {
        log.error("Handle API Response Exception:  {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), ex.getHttpStatus());
    }
}


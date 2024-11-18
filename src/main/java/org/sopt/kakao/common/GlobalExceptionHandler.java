package org.sopt.kakao.common;

import java.util.Objects;
import jakarta.validation.ConstraintViolationException;
import org.sopt.kakao.common.dto.ErrorMessage;
import org.sopt.kakao.common.dto.ErrorResponse;
import org.sopt.kakao.common.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException appException) {
        ErrorMessage errorMessage = appException.getErrorMessage();
        ErrorResponse errorResponse = ErrorResponse.of(errorMessage);
        return ResponseEntity.status(errorMessage.getStatus()).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST.value(),
                        Objects.requireNonNull(e.getBindingResult().getFieldError())
                                .getDefaultMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleGenericException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }
}

package org.sopt.kakao.common;

import jakarta.validation.ConstraintViolationException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.sopt.kakao.common.dto.ErrorMessage;
import org.sopt.kakao.common.dto.ErrorResponse;
import org.sopt.kakao.common.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class) // AppException 처리
    public ResponseEntity<ErrorResponse> handleAppException(AppException appException) {
        log.error("AppException occurred: {}", appException.getMessage(), appException);
        ErrorMessage errorMessage = appException.getErrorMessage();
        ErrorResponse errorResponse = ErrorResponse.of(errorMessage);
        return ResponseEntity.status(errorMessage.getStatus()).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMessage = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        log.warn("Validation failed: {}", errorMessage, e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), errorMessage));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleGenericException(ConstraintViolationException e) {
        log.warn("ConstraintViolationException occurred: {}", e.getMessage(), e);

        String errorMessage = e.getConstraintViolations()
                .stream()
                .map(violation -> {
                    String propertyPath = violation.getPropertyPath().toString();
                    String fieldName = propertyPath.substring(propertyPath.lastIndexOf(".") + 1);
                    return fieldName + ": " + violation.getMessage();
                })
                .findFirst()
                .orElse("Pathvariable 예외");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), errorMessage));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException e) {
        log.info("Missing request parameter: {}", e.getParameterName(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), e.getParameterName()));
    }

    @ExceptionHandler(Exception.class) // 모든 예외처리
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception e) {
        log.error("Unexpected exception occurred: {}", e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }
}

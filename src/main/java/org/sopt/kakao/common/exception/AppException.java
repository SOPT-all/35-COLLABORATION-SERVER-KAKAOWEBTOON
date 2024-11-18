package org.sopt.kakao.common.exception;

import lombok.Getter;
import org.sopt.kakao.common.dto.ErrorMessage;

@Getter
public class AppException extends RuntimeException {
    private ErrorMessage errorMessage;

    public AppException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}

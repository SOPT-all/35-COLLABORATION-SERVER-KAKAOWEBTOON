package org.sopt.kakao.common.exception;

import lombok.Getter;
import org.sopt.kakao.common.dto.ErrorMessage;

@Getter
public class AppException extends RuntimeException {
    private ErrorMessage errorMessage; // 에러 메시지 정보를 담은 객체

    public AppException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());  // RuntimeException의 메시지로 설정
        this.errorMessage = errorMessage;  // ErrorMessage 객체 저장
    }
}

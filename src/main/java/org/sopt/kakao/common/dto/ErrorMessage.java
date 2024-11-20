package org.sopt.kakao.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    // 예시로 써놓은 것
    WEBTOON_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 웹툰을 찾을 수 없습니다."),
    // 유효성 검사 실패 메시지 추가
    CONSTRAINT_VIOLATION(HttpStatus.BAD_REQUEST.value(), "요청 데이터가 유효하지 않습니다.");

    private final int status;
    private final String message;
}

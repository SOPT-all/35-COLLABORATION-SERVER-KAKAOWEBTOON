package org.sopt.kakao.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

    // 예시로 써놓은 것
    WEBTOON_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ID에 해당하는 웹툰을 찾을 수 없습니다."),
    INVALID_DAY(HttpStatus.BAD_REQUEST.value(), "잘못된 요일 요청입니다."),
    THUMNAIL_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "썸네일을 찾을 수 없습니다.");

    private final int status;
    private final String message;
}

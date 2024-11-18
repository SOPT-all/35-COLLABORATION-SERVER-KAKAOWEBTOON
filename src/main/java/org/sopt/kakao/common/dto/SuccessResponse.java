package org.sopt.kakao.common.dto;

import org.springframework.http.HttpStatus;

public record SuccessResponse<T>(
        int status,
        T data
) {
    public static SuccessResponse of() {
        return new SuccessResponse(HttpStatus.OK.value(), null);
    }

    public static <T> SuccessResponse<T> of(T data) {
        return new SuccessResponse<>(HttpStatus.OK.value(), data);
    }
}

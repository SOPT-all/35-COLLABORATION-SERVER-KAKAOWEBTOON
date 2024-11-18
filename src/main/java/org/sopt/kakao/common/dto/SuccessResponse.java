package org.sopt.kakao.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
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

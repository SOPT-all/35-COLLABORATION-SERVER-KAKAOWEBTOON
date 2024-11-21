package org.sopt.kakao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.sopt.kakao.common.dto.ErrorMessage;
import org.sopt.kakao.common.exception.AppException;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Day {
    MON("MON"),
    TUE("TUE"),
    WED("WED"),
    THU("THU"),
    FRI("FRI"),
    SAT("SAT"),
    SUN("SUN");

    private final String day;

    public static Day fromString(String dayString) {
        return Arrays.stream(values())
                .filter(day -> day.day.equalsIgnoreCase(dayString))
                .findFirst()
                .orElseThrow(() -> new AppException(ErrorMessage.INVALID_DAY));
    }

}

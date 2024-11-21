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
    MON("mon"),
    TUE("tue"),
    WED("wed"),
    THU("thu"),
    FRI("fri"),
    SAT("sat"),
    SUN("sun");

    private final String day;

    public static Day convertToDay(String dayString) {
        return Arrays.stream(values())
                .filter(day -> day.day.equals(dayString))
                .findFirst()
                .orElseThrow(() -> new AppException(ErrorMessage.INVALID_DAY));
    }

}

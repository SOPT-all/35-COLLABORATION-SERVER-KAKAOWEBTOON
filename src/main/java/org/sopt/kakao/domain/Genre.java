package org.sopt.kakao.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Genre {
    DAILY_COMEDY("일상/개그"),
    ROMANCE("로맨스"),
    DRAMA("드라마"),
    SCHOOL_ACTION("학원/액션"),
    FANTASY_ADVENTURE("판타지/무협"),
    THRILLER("스릴러");

    private final String description;
}


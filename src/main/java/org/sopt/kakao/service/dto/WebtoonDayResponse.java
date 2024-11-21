package org.sopt.kakao.service.dto;

import org.sopt.kakao.domain.Webtoon;

public record WebtoonDayResponse(
        long id,
        String title,
        String image
) {
    public static WebtoonDayResponse of(Webtoon webtoon){
        return new WebtoonDayResponse(
                webtoon.getId(),
                webtoon.getTitle(),
                webtoon.getImage()
        );
    }
}

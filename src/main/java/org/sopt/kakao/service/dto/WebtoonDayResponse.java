package org.sopt.kakao.service.dto;

import jakarta.annotation.Nullable;
import org.sopt.kakao.domain.Thumbnail;
import org.sopt.kakao.domain.Webtoon;

import java.util.Optional;

public record WebtoonDayResponse(
        long id,
        String title,
        @Nullable
        String image
) {
    public static WebtoonDayResponse of(Webtoon webtoon, Optional<Thumbnail> thumbnail){
        return new WebtoonDayResponse(
                webtoon.getId(),
                webtoon.getTitle(),
                thumbnail.map(Thumbnail::getImage).orElse(null)
        );
    }
}

package org.sopt.kakao.service.dto;

import jakarta.annotation.Nullable;
import org.sopt.kakao.domain.Thumbnail;
import org.sopt.kakao.domain.Webtoon;

import java.util.Optional;

public record WebtoonRecentViewResponse(
        String title,
        String author,
        @Nullable
        String image,
        String genre,
        String promotion) {
    public static WebtoonRecentViewResponse of(Webtoon webtoon, Optional<Thumbnail> thumbnail){
        return new WebtoonRecentViewResponse(
                webtoon.getTitle(),
                webtoon.getAuthor(),
                thumbnail.map(Thumbnail::getImage).orElse(null),
                webtoon.getGenre().getDescription(),
                webtoon.getPromotion()
        );
    }

}

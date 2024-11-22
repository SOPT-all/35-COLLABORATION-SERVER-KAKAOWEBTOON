package org.sopt.kakao.service.dto;

import jakarta.annotation.Nullable;
import org.sopt.kakao.domain.Thumbnail;

public record WebtoonRecentViewResponse(
        String title,
        String author,
        @Nullable
        String image,
        String genre,
        String promotion) {
    public static WebtoonRecentViewResponse of(Thumbnail thumbnail) {
        return new WebtoonRecentViewResponse(
                thumbnail.getWebtoon().getTitle(),
                thumbnail.getWebtoon().getAuthor(),
                thumbnail.getImage(),
                thumbnail.getWebtoon().getGenre().getDescription(),
                thumbnail.getWebtoon().getPromotion()
        );
    }
}

package org.sopt.kakao.service.dto;

import java.util.Optional;
import org.sopt.kakao.domain.Thumbnail;
import org.sopt.kakao.domain.Webtoon;

public record WebtoonSearchResponse(
        String title,
        String author,
        String image,
        String genre,
        String promotion
) {
    public static WebtoonSearchResponse of(final Webtoon webtoon, final Optional<Thumbnail> thumbnail) {
        return new WebtoonSearchResponse(
                webtoon.getTitle(),
                webtoon.getAuthor(),
                thumbnail.map(Thumbnail::getImage).orElse(null),
                webtoon.getGenre().getDescription(),
                webtoon.getPromotion()
        );
    }
}

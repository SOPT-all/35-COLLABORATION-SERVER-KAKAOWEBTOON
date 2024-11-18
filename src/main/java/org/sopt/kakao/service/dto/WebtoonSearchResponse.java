package org.sopt.kakao.service.dto;

import org.sopt.kakao.domain.Webtoon;

public record WebtoonSearchResponse(
        String title,
        String author,
        String image,
        String genre,
        String promotion
) {
    public static WebtoonSearchResponse of(final Webtoon webtoon) {
        return new WebtoonSearchResponse(webtoon.getTitle(), webtoon.getAuthor(), webtoon.getImage(),
                webtoon.getGenre().getDescription(), webtoon.getPromotion());
    }
}

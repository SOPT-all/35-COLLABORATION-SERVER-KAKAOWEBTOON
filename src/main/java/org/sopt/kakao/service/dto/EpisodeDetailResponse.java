package org.sopt.kakao.service.dto;

import java.util.Optional;
import org.sopt.kakao.domain.Thumbnail;
import org.sopt.kakao.domain.Webtoon;

public record EpisodeDetailResponse(
        String title,
        String author,
        String genre,
        int viewCount,
        int heartCount,
        String image,
        int coupon,
        String promotion) {
    public static EpisodeDetailResponse of(final Webtoon webtoon, final Optional<Thumbnail> thumbnail) {
        return new EpisodeDetailResponse(
                webtoon.getTitle(),
                webtoon.getAuthor(),
                webtoon.getGenre().getDescription(),
                webtoon.getViewCount(),
                webtoon.getHeartCount(),
                thumbnail.map(Thumbnail::getImage).orElse(null),
                webtoon.getCoupon(),
                webtoon.getPromotion()
        );
    }
}

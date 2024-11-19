package org.sopt.kakao.service.dto;

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
    public static EpisodeDetailResponse of(final Webtoon webtoon) {
        return new EpisodeDetailResponse(webtoon.getTitle(), webtoon.getAuthor(), webtoon.getGenre().getDescription(),
                webtoon.getViewCount(), webtoon.getHeartCount(), webtoon.getImage(), webtoon.getCoupon(), webtoon.getPromotion());
    }
}

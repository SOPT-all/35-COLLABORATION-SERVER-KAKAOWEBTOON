package org.sopt.kakao.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopt.kakao.domain.Day;
import org.sopt.kakao.domain.Thumbnail;
import org.sopt.kakao.domain.Webtoon;
import org.sopt.kakao.repository.ThumbnailRepository;
import org.sopt.kakao.repository.WebtoonRepository;
import org.sopt.kakao.service.dto.WebtoonDayListResponse;
import org.sopt.kakao.service.dto.WebtoonDayResponse;
import org.sopt.kakao.service.dto.WebtoonListResponse;
import org.sopt.kakao.service.dto.WebtoonRecentViewListResponse;
import org.sopt.kakao.service.dto.WebtoonRecentViewResponse;
import org.sopt.kakao.service.dto.WebtoonSearchResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebtoonService {

    private final WebtoonRepository webtoonRepository;
    private final ThumbnailRepository thumbnailRepository;

    public WebtoonListResponse search(final String title) {
        List<Webtoon> findWebtoons = webtoonRepository.findAllByTitle(title);
        List<WebtoonSearchResponse> webtoons = findWebtoons.stream()
                .map(webtoon -> WebtoonSearchResponse.of(webtoon, findImage(webtoon)))
                .toList();
        return new WebtoonListResponse(webtoons);
    }

    public WebtoonDayListResponse findWebtoonsByDay(final String dayString) {
        Day day = Day.convertToDay(dayString);
        List<WebtoonDayResponse> webtoons = webtoonRepository.findByDay(day).stream()
                .map(WebtoonDayResponse::of)
                .toList();
        return new WebtoonDayListResponse(webtoons);
    }

    public WebtoonRecentViewListResponse getRecentWebtoons() {
        List<Webtoon> recentWebtoons = webtoonRepository.findTop5ByOrderByIdDesc();
        List<WebtoonRecentViewResponse> webtoonResponses = recentWebtoons.stream()
                .map(webtoon -> WebtoonRecentViewResponse.of(webtoon, findImage(webtoon)))
                .toList();
        return new WebtoonRecentViewListResponse(webtoonResponses);
    }

    private Optional<Thumbnail> findImage(final Webtoon webtoon) {
        List<Thumbnail> thumbnails = thumbnailRepository.findByWebtoon(webtoon);
        return thumbnails.stream().reduce((first, second) -> second);
    }
}

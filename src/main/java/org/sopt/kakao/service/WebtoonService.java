package org.sopt.kakao.service;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.sopt.kakao.common.dto.ErrorMessage;
import org.sopt.kakao.common.exception.AppException;
import org.sopt.kakao.domain.Day;
import org.sopt.kakao.domain.Thumbnail;
import org.sopt.kakao.domain.Webtoon;
import org.sopt.kakao.repository.ThumbnailRepository;
import org.sopt.kakao.repository.WebtoonRepository;
import org.sopt.kakao.service.dto.*;
import org.springframework.stereotype.Service;

import static org.sopt.kakao.common.dto.ErrorMessage.THUMNAIL_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class WebtoonService {

    private final WebtoonRepository webtoonRepository;
    private final ThumbnailRepository thumbnailRepository;

    public WebtoonListResponse search(final String title) {
        List<Webtoon> findWebtoons = webtoonRepository.findAllByTitle(title);
        List<WebtoonSearchResponse> webtoons = findWebtoons.stream()
                .map(WebtoonSearchResponse::of)
                .toList();
        return new WebtoonListResponse(webtoons);
    }


    public WebtoonDayListResponse findWebtoonsByDay(final String dayString) {
        Day day = Day.convertToDay(dayString);
        List<WebtoonDayResponse> webtoons = webtoonRepository.findByDay(day).stream()
                .map(webtoon -> WebtoonDayResponse.of(webtoon, findThumbnail(webtoon)))
                .toList();
        return new WebtoonDayListResponse(webtoons);
    }


    private Optional<Thumbnail> findThumbnail(final Webtoon webtoon) {
        List<Thumbnail> thumbnail = thumbnailRepository.findByWebtoon(webtoon);
        return thumbnail.stream().findFirst();
    }

    public WebtoonRecentViewListResponse getRecentWebtoons() {
        List<Thumbnail> recentWebtoons = thumbnailRepository.findTop5ByOrderByIdDesc();
        List<WebtoonRecentViewResponse> webtoonResponses = recentWebtoons.stream()
                .map(WebtoonRecentViewResponse::of)
                .toList();
        return new WebtoonRecentViewListResponse(webtoonResponses);
    }


    private Optional<Thumbnail> findImage(final Webtoon webtoon) {
        List<Thumbnail> thumbnails = thumbnailRepository.findByWebtoon(webtoon);
        return thumbnails.stream().reduce((first, second) -> second);
    }

}

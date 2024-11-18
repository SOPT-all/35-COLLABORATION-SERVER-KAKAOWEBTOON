package org.sopt.kakao.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopt.kakao.domain.Webtoon;
import org.sopt.kakao.repository.WebtoonRepository;
import org.sopt.kakao.service.dto.WebtoonListResponse;
import org.sopt.kakao.service.dto.WebtoonSearchResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebtoonService {

    private final WebtoonRepository webtoonRepository;

    public WebtoonListResponse search(final String title) {
        List<Webtoon> findWebtoons = webtoonRepository.findAllByTitle(title);
        List<WebtoonSearchResponse> webtoons = findWebtoons.stream()
                .map(WebtoonSearchResponse::of)
                .toList();
        return new WebtoonListResponse(webtoons);
    }
}

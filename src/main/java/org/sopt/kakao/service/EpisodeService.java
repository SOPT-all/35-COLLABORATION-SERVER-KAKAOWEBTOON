package org.sopt.kakao.service;

import lombok.RequiredArgsConstructor;
import org.sopt.kakao.common.dto.ErrorMessage;
import org.sopt.kakao.common.exception.AppException;
import org.sopt.kakao.domain.Webtoon;
import org.sopt.kakao.repository.WebtoonRepository;
import org.sopt.kakao.service.dto.EpisodeDetailResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final WebtoonRepository webtoonRepository;

    public EpisodeDetailResponse getDetail(final long id) {
        Webtoon webtoon = webtoonRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessage.WEBTOON_NOT_FOUND));
        return EpisodeDetailResponse.of(webtoon);
    }

}

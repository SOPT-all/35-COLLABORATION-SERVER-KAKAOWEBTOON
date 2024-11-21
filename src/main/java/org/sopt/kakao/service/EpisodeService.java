package org.sopt.kakao.service;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.sopt.kakao.common.dto.ErrorMessage;
import org.sopt.kakao.common.exception.AppException;
import org.sopt.kakao.domain.Episode;
import org.sopt.kakao.domain.Webtoon;
import org.sopt.kakao.repository.EpisodeRepository;
import org.sopt.kakao.repository.WebtoonRepository;
import org.sopt.kakao.service.dto.EpisodeDetailResponse;
import org.sopt.kakao.service.dto.EpisodeResponse;
import org.sopt.kakao.service.dto.EpisodesResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final WebtoonRepository webtoonRepository;
    private final EpisodeRepository episodeRepository;

    public EpisodeDetailResponse getDetail(final long id) {
        Webtoon webtoon = findById(id);
        return EpisodeDetailResponse.of(webtoon);
    }

    public EpisodesResponse getEpisodes(final long id) {
        Webtoon webtoon = findById(id);
        List<Episode> findEpisodes = findAllEpisode(webtoon);

        LocalDate now = LocalDate.now();
        List<EpisodeResponse> episodes = findEpisodes.stream()
                .map(episode -> EpisodeResponse.of(episode, episode.findDayUntilFree(now)))
                .toList();
        return new EpisodesResponse(episodes);
    }

    private Webtoon findById(final long id) {
        return webtoonRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorMessage.WEBTOON_NOT_FOUND));
    }

    private List<Episode> findAllEpisode(final Webtoon webtoon) {
        return episodeRepository.findAllByWebtoon(webtoon);
    }
}

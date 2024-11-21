package org.sopt.kakao.service.dto;

import java.time.LocalDate;
import org.sopt.kakao.domain.Episode;

public record EpisodeResponse(
        int turn,
        String url,
        String title,
        int status,
        LocalDate date,
        int dayUntilFree
) {
    public static EpisodeResponse of(final Episode episode, final int dayUntilFree) {
        return new EpisodeResponse(episode.getTurn(), episode.getImage(), episode.getTitle(), episode.getStatus(),
                episode.getViewDate(), dayUntilFree);

    }
}

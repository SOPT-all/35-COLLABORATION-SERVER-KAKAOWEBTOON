package org.sopt.kakao.service.dto;

import java.util.List;

public record EpisodesResponse(
        List<EpisodeResponse> episodes
) {
}

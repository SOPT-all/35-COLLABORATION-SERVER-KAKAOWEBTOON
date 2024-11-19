package org.sopt.kakao.service.dto;

import java.util.List;

public record EpisodeListResponse(
        List<EpisodeDetailResponse> episodes
) {
}
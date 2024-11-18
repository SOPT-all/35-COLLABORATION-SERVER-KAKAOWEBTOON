package org.sopt.kakao.service.dto;

import java.util.List;

public record WebtoonListResponse(
        List<WebtoonSearchResponse> webtoons
) {
}

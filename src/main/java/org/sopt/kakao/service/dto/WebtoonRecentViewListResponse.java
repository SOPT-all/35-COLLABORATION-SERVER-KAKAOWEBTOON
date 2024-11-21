package org.sopt.kakao.service.dto;

import java.util.List;

public record WebtoonRecentViewListResponse(
        List<WebtoonRecentViewResponse> webtoons
) {}

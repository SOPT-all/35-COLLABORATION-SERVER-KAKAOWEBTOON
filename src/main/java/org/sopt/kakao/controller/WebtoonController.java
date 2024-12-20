package org.sopt.kakao.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.kakao.common.dto.SuccessResponse;
import org.sopt.kakao.service.WebtoonService;
import org.sopt.kakao.service.dto.WebtoonDayListResponse;
import org.sopt.kakao.service.dto.WebtoonListResponse;
import org.sopt.kakao.service.dto.WebtoonRecentViewListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WebtoonController {

    private final WebtoonService webtoonService;

    @GetMapping("/webtoons/search")
    private ResponseEntity<SuccessResponse> searchWebtoon(@RequestParam final String title) {
        WebtoonListResponse webtoons = webtoonService.search(title);
        return ResponseEntity.ok(SuccessResponse.of(webtoons));
    }

    @GetMapping("/webtoons")
    public ResponseEntity<SuccessResponse> getWebtoonsByDay(@RequestParam final String day) {
        WebtoonDayListResponse webtoons = webtoonService.findWebtoonsByDay(day);
        return ResponseEntity.ok(SuccessResponse.of(webtoons));
    }

    @GetMapping("webtoons/recent")
    public ResponseEntity<SuccessResponse> getRecentWebtoons() {
        WebtoonRecentViewListResponse recentWebtoons = webtoonService.getRecentWebtoons();
        return ResponseEntity.ok(SuccessResponse.of(recentWebtoons));
    }
}

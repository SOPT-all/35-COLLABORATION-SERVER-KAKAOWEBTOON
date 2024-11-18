package org.sopt.kakao.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.kakao.common.dto.SuccessResponse;
import org.sopt.kakao.service.WebtoonService;
import org.sopt.kakao.service.dto.WebtoonListResponse;
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

    @GetMapping("/webtoons")
    private ResponseEntity<SuccessResponse> searchWebtoon(@RequestParam final String title) {
        WebtoonListResponse webtoons = webtoonService.search(title);
        return ResponseEntity.ok(SuccessResponse.of(webtoons));
    }
}

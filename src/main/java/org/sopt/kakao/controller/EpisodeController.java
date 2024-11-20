package org.sopt.kakao.controller;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.sopt.kakao.common.dto.SuccessResponse;
import org.sopt.kakao.service.EpisodeService;
import org.sopt.kakao.service.dto.EpisodeDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Validated // @PathVariable 검증 활성화
public class EpisodeController {

    private final EpisodeService episodeService;

    @GetMapping("/episodes/{id}")
    public ResponseEntity<SuccessResponse> getDetailEpisode(
            @PathVariable @Min(value = 1, message = "ID는 1 이상이어야 합니다.") final long id // 커스텀 메시지 추가
    ) {
        EpisodeDetailResponse episode = episodeService.getDetail(id);
        return ResponseEntity.ok(SuccessResponse.of(episode));
    }
}
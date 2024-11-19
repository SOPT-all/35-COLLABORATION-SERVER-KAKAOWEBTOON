package org.sopt.kakao.controller;

import lombok.RequiredArgsConstructor;
import org.sopt.kakao.common.dto.SuccessResponse;
import org.sopt.kakao.service.EpisodeService;
import org.sopt.kakao.service.dto.EpisodeListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EpisodeController {

    private final EpisodeService episodeService;

    @GetMapping("/episodes/{id}")
    private ResponseEntity<SuccessResponse> getDetailEpisode(@PathVariable final long id) {
        EpisodeListResponse episodes = episodeService.getDetail(id);
        return ResponseEntity.ok(SuccessResponse.of(episodes));
    }
}

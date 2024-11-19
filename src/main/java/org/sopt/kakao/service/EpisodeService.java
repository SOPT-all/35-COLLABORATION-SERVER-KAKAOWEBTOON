package org.sopt.kakao.service;

import lombok.RequiredArgsConstructor;
import org.sopt.kakao.common.dto.ErrorMessage;
import org.sopt.kakao.common.exception.AppException;
import org.sopt.kakao.domain.Episode;
import org.sopt.kakao.domain.Webtoon;
import org.sopt.kakao.repository.EpisodeRepository;
import org.sopt.kakao.repository.WebtoonRepository;
import org.sopt.kakao.service.dto.EpisodeDetailResponse;
import org.sopt.kakao.service.dto.EpisodeListResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final WebtoonRepository webtoonRepository;

   public EpisodeListResponse getDetail(final long id){
       Webtoon webtoon = webtoonRepository.findById(id)
               .orElseThrow(() -> new AppException(ErrorMessage.WEBTOON_NOT_FOUND));
       EpisodeDetailResponse response = EpisodeDetailResponse.of(webtoon);

       // 단일 객체를 리스트로 감싸 반환
       return new EpisodeListResponse(List.of(response));
   }
}

package org.sopt.kakao.repository;

import java.util.List;
import org.sopt.kakao.domain.Episode;
import org.sopt.kakao.domain.Webtoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {

    List<Episode> findAllByWebtoon(Webtoon webtoon);
}

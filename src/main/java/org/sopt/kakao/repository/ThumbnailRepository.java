package org.sopt.kakao.repository;

import org.sopt.kakao.domain.Thumbnail;
import org.sopt.kakao.domain.Webtoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThumbnailRepository extends JpaRepository<Thumbnail, Long> {
    List<Thumbnail> findByWebtoon(Webtoon webtoon);

    @Query("SELECT t FROM Thumbnail t JOIN t.webtoon ORDER BY t.id DESC")
    List<Thumbnail> findTop5ByOrderByIdDesc();
}

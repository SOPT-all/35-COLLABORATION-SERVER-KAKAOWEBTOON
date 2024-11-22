package org.sopt.kakao.repository;

import org.sopt.kakao.domain.Thumbnail;
import org.sopt.kakao.domain.Webtoon;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ThumbnailRepository extends JpaRepository<Thumbnail, Long> {
    List<Thumbnail> findByWebtoon(Webtoon webtoon);

    @Query("select t from Thumbnail t join fetch t.webtoon ORDER BY t.id DESC")
    List<Thumbnail> findTop5ByOrderByIdDesc(Pageable pageable);
}

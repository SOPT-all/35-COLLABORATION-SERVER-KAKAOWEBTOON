package org.sopt.kakao.repository;

import org.sopt.kakao.domain.Webtoon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebtoonRepository extends JpaRepository<Webtoon, Long> {
}

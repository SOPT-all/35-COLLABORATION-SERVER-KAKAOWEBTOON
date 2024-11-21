package org.sopt.kakao.repository;

import java.util.List;

import org.sopt.kakao.domain.Day;
import org.sopt.kakao.domain.Webtoon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WebtoonRepository extends JpaRepository<Webtoon, Long> {

    @Query("SELECT w FROM Webtoon w WHERE w.title LIKE %:title%")
    List<Webtoon> findAllByTitle(String title);

    List<Webtoon> findByDay(Day day);
}

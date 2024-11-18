package org.sopt.kakao.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Webtoon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private int heartCount;

    private int viewCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Day day;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;

    private int coupon;

    private String promotion;
}

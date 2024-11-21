package org.sopt.kakao.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Webtoon webtoon;

    private LocalDate viewDate;

    private String title;

    private int turn;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;

    private int status;

    public int findDayUntilFree(final LocalDate now) {
        if (now.isBefore(viewDate)) {
            return (int) java.time.temporal.ChronoUnit.DAYS.between(now, viewDate);
        }
        return 0;
    }
}

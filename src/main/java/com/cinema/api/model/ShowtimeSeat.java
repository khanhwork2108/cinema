package com.cinema.api.model;

import com.cinema.api.model.enums.ShowtimeSeatStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "showtime_seats",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"showtime_id", "seat_id"}
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowtimeSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // N ShowtimeSeat -> 1 Showtime
    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime;

    // N ShowtimeSeat -> 1 Seat
    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ShowtimeSeatStatus status;

    // Account đang giữ ghế
    @ManyToOne
    @JoinColumn(name = "locked_by_account_id")
    private Account lockedByAccount;

    // Thời điểm hết hạn giữ ghế
    private LocalDateTime lockedUntil;
}
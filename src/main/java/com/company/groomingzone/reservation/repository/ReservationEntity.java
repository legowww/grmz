package com.company.groomingzone.reservation.repository;

import com.company.groomingzone.common.BaseEntity;
import com.company.groomingzone.reservation.domain.ReservationStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reservations")
public class ReservationEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "barber_id", nullable = false)
    private Long barberId;

    @Column(name = "barber_shop_id", nullable = false)
    private Long barberShopId;

    @Column(name = "barber_shop_schedule_id", nullable = false)
    private Long barberShopScheduleId;

    @Column(name = "barber_shop_style_id")
    private Long barberShopStyleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "reservation_status", nullable = false)
    private ReservationStatus reservationStatus;

    @Builder
    public ReservationEntity(Long id, Long customerId, Long barberId, Long barberShopId, Long barberShopScheduleId, Long barberShopStyleId, ReservationStatus reservationStatus) {
        this.id = id;
        this.customerId = customerId;
        this.barberId = barberId;
        this.barberShopId = barberShopId;
        this.barberShopScheduleId = barberShopScheduleId;
        this.barberShopStyleId = barberShopStyleId;
        this.reservationStatus = reservationStatus;
    }
}

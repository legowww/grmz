package com.company.groomingzone.reservation;

import com.company.groomingzone.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reservations")
public class ReservationEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "reservation_status", nullable = false, length = 10)
    private String reservationStatus;
}

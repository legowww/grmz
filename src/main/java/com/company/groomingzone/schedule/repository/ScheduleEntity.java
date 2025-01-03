package com.company.groomingzone.schedule.repository;

import com.company.groomingzone.common.BaseEntity;
import com.company.groomingzone.reservation.domain.ReservationStatus;
import com.company.groomingzone.schedule.domain.ScheduleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;


@Getter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "barber_shop_schedules")
public class ScheduleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barber_id", nullable = false)
    private Long barberId;

    @Column(name = "barber_shop_id", nullable = false)
    private Long barberShopId;

    @Column(name = "customer_id", nullable = true)
    private Long customerId;

    @Column(name = "start_time", nullable = false)
    private OffsetDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private OffsetDateTime endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ScheduleStatus scheduleStatus;
}

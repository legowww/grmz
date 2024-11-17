package com.company.groomingzone.barber;

import com.company.groomingzone.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "barber_shop_schedules")
public class BarberShopScheduleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barber_id", nullable = false)
    private Long barberId;

    @Column(name = "barber_shop_id", nullable = false)
    private Long barberShopId;

    @Column(name = "date_time", nullable = false)
    private OffsetDateTime dateTime;
}

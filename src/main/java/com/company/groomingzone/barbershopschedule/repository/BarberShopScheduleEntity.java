package com.company.groomingzone.barbershopschedule.repository;

import com.company.groomingzone.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Getter
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

    @Column(name = "is_reserved", nullable = false)
    private Boolean isReserved;

    public BarberShopScheduleEntity(Long barberId, Long barberShopId, OffsetDateTime dateTime) {
        this.barberId = barberId;
        this.barberShopId = barberShopId;
        this.dateTime = dateTime;
    }


    @Override
    public String toString() {
        return "BarberShopScheduleEntity{" +
                "id=" + id +
                ", barberId=" + barberId +
                ", barberShopId=" + barberShopId +
                ", dateTime=" + dateTime +
                '}';
    }
}

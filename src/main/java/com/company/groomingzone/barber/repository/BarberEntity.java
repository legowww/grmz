package com.company.groomingzone.barber.repository;

import com.company.groomingzone.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "barbers")
@Entity
public class BarberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barber_shop_id", nullable = false)
    private Long barberShopId;

    @Column(nullable = false, length = 500)
    private String introduction;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Builder
    private BarberEntity(Long id, Long barberShopId, String introduction, Boolean isActive) {
        this.id = id;
        this.barberShopId = barberShopId;
        this.introduction = introduction;
        this.isActive = isActive;
    }
}

package com.company.groomingzone.barber;

import com.company.groomingzone.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "barbers")
public class BarberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "barber_shop_id", nullable = false)
    private Long barberShopId;

    @Column(nullable = false, length = 500)
    private String introduction;

    @Column(nullable = false)
    private Boolean isActive = true;
}

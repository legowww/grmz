package com.company.groomingzone.style.repository;

import com.company.groomingzone.common.BaseEntity;
import com.company.groomingzone.style.domain.StyleCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "barber_shop_styles")
public class StyleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "barber_shop_id", nullable = false)
    private Long barberShopId;

    @Column(name = "barber_id", nullable = false)
    private Long barberId;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(length = 500)
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(name ="category", length = 20, nullable = false)
    private StyleCategory styleCategory;

    @Builder
    public StyleEntity(Long id, Long barberShopId, Long barberId, String name, BigDecimal price, String description, String url, StyleCategory styleCategory) {
        this.id = id;
        this.barberShopId = barberShopId;
        this.barberId = barberId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.url = url;
        this.styleCategory = styleCategory;
    }
}

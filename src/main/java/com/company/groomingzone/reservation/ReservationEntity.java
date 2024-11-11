package com.company.groomingzone.reservation;

import jakarta.persistence.*;

@Entity
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

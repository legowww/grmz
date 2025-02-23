package com.company.groomingzone.barber.service;

import com.company.groomingzone.barber.domain.Barber;

public interface BarberRepository {

    Barber findById(long id);
}

package com.company.groomingzone.style.domain;

import java.util.List;

public interface StyleRepository {

    Style findById(Long styleId);

    List<Style> findBarberStyleList(Long barberShopId, Long barberId);
}

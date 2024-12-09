package com.company.groomingzone.barber.service;

import com.company.groomingzone.barber.domain.Barber;
import com.company.groomingzone.barber.repository.BarberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarberServiceImpl implements BarberService {

    private final BarberRepository barberRepository;

    @Override
    public Barber readBarberById(Long barberId) {
        return barberRepository.findById(barberId);
    }
}

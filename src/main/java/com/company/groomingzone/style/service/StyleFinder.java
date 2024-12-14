package com.company.groomingzone.style.service;

import com.company.groomingzone.style.domain.Style;
import com.company.groomingzone.style.domain.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class StyleFinder {

    private final StyleRepository styleRepository;


    @Transactional(readOnly = true)
    public Style findById(Long styleId) {
        return styleRepository.findById(styleId);
    }


    @Transactional(readOnly = true)
    public List<Style> findBarberStyleList(Long barberShopId, Long barberId) {
        return styleRepository.findBarberStyleList(barberShopId, barberId);
    }
}

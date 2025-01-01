package com.company.groomingzone.style.repository;

import com.company.groomingzone.style.domain.Style;
import com.company.groomingzone.style.domain.StyleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class StyleJpaRepository implements StyleRepository {

    private final StyleEntityRepository styleEntityRepository;
    private final StyleMapper styleMapper;

    @Override
    public Style findById(Long styleId) {
        StyleEntity styleEntity = styleEntityRepository.findById(styleId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 스타일입니다."));

        return styleMapper.mapToDomainEntity(styleEntity);
    }

    @Override
    public List<Style> findBarberStyleList(Long barberShopId, Long barberId) {
        return List.of();
    }
}

package com.company.groomingzone.style.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Repository
public interface StyleEntityRepository extends JpaRepository<StyleEntity, Long> {
}

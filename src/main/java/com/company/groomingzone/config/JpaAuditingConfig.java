package com.company.groomingzone.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.OffsetDateTime;
import java.util.Optional;


@EnableJpaAuditing(dateTimeProviderRef = "offSetDateTimeProvider")
@Configuration
public class JpaAuditingConfig {

    /*
        JPA의 @CreatedAt @LastModifiedDate은
        기본적으로 LocalDateTime, LocalDate, LocalTime 타입만 지원하기 떄문에
        OffsetDateTime 을 지원하도록 설정
     */
    @Bean("offSetDateTimeProvider")
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(OffsetDateTime.now());
    }
}

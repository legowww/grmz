package com.company.groomingzone.common.repository.querydsl;

import org.springframework.data.domain.Page;

import java.util.List;

// 페이징 응답 클래스
public record PageableResponse<T>(
        List<T> content,
        int pageNumber,
        int pageSize,
        long totalElements,
        int totalPages
) {

    public static <T> PageableResponse<T> from(Page<T> page) {
        return new PageableResponse<>(
                page.getContent(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}

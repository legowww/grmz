package com.company.groomingzone.common.repository.querydsl;

import org.springframework.data.domain.Slice;

import java.util.List;

// 무한스크롤용 응답 클래스
public record ScrollResponse<T>(
        List<T> content,
        int pageNumber,
        int pageSize,
        boolean hasNext
) {

    public static <T> ScrollResponse<T> from(Slice<T> slice) {
        return new ScrollResponse<>(
                slice.getContent(),
                slice.getNumber(),
                slice.getSize(),
                slice.hasNext()
        );
    }
}

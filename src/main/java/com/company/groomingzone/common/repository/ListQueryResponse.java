package com.company.groomingzone.common.repository;


import lombok.Builder;

import java.util.List;

@Builder
public record ListQueryResponse<T>(
        List<T> content,
        long totalElements,
        int totalPages,
        int pageNumber,
        int pageSize,
        boolean hasNext
) {

    public static <T> ListQueryResponse<T> createScrollResponse(List<T> content, SearchCondition condition) {
        // 다음 스크롤 존재 여부 확인
        boolean hasNext = content.size() > condition.getLimit();

        // 실제로 필요한 개수만큼만 반환하기 위해 마지막 항목 제거
        if (hasNext) {
            content.remove(condition.getLimit());
        }

        return ListQueryResponse.<T>builder()
                .content(content)
                .pageNumber(condition.getOffset())
                .pageSize(condition.getLimit())
                .hasNext(hasNext)
                .build();
    }
}

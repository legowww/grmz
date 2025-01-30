package com.company.groomingzone.common.repository.querydsl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.SliceImpl;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SliceUtility {

    public static <T> SliceImpl<T> execute(Pageable pageable, List<T> content) {
        // 다음 페이지 존재 여부 확인
        boolean hasNext = content.size() > pageable.getPageSize();

        // 실제로 필요한 개수만큼만 반환하기 위해 마지막 항목 제거
        if (hasNext) {
            content.remove(pageable.getPageSize());
        }
        // SliceImpl 사용하여 결과 반환
        return new SliceImpl<>(content, pageable, hasNext);
    }
}

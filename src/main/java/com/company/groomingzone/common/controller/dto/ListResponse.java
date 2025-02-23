package com.company.groomingzone.common.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record ListResponse<T>(
        List<T> content,
        PageResponse pageResponse,
        ScrollResponse scrollResponse
) {

    public static <T> ListResponse<T> ofScroll(List<T> content, ScrollResponse scrollResponse) {
        return ListResponse.<T>builder()
                .content(content)
                .scrollResponse(scrollResponse)
                .build();
    }

    public static <T> ListResponse<T> ofPage(List<T> content, PageResponse pageResponse) {
        return ListResponse.<T>builder()
                .content(content)
                .pageResponse(pageResponse)
                .build();
    }
}

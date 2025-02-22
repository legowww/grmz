package com.company.groomingzone.common.controller.dto;

public record ScrollResponse(
        int pageNumber,
        int pageSize,
        boolean hasNext
) {
}

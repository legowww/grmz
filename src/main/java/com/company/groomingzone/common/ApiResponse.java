package com.company.groomingzone.common;

import java.time.OffsetDateTime;

public record ApiResponse<T>(
        String status,
        String message,
        T data,
        String timeStamp
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("SUCCESS", null, data, OffsetDateTime.now().toString());
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>("SUCCESS", message, data, OffsetDateTime.now().toString());
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>("ERROR", message, null, OffsetDateTime.now().toString());
    }
}

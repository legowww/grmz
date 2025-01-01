package com.company.groomingzone.security;

import com.company.groomingzone.common.exception.ExceptionCode;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.MediaType;

public class ErrorResponder {
    public static void sendErrorResponse(HttpServletResponse response, ExceptionCode exceptionCode) throws IOException {
        Gson gson = new Gson();
        ErrorResponse errorResponse = ErrorResponse.of(exceptionCode);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("utf-8");
        response.setStatus(exceptionCode.getStatus());
        response.getWriter().write(gson.toJson(errorResponse, ErrorResponse.class));
    }
}


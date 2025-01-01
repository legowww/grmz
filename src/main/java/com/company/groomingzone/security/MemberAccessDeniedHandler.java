package com.company.groomingzone.security;

import com.company.groomingzone.common.exception.ExceptionCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

@Slf4j
public class MemberAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request,
        HttpServletResponse response,
        AccessDeniedException accessDeniedException) throws IOException {
        ErrorResponder.sendErrorResponse(response, ExceptionCode.UNAUTHORIZED);
        log.warn("Forbidden error happened: {}", accessDeniedException.getMessage());
    }
}
package com.company.groomingzone.common.exception;

import com.company.groomingzone.common.ApiResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handle(Exception exception) {
        String error = exception.getLocalizedMessage().toString();
        log.error("Exception: {}", error);

        return ResponseEntity.badRequest().body(ApiResponse.error(error));
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse> handle(EntityNotFoundException exception) {
        String error = exception.getLocalizedMessage().toString();
        log.error("EntityNotFoundException: {}", error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error(error));
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> handle(DataIntegrityViolationException exception) {
        String error = exception.getLocalizedMessage().toString();
        log.error("DataIntegrityViolationException: {}", error);
        return ResponseEntity.badRequest().body(ApiResponse.error(error));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handle(MethodArgumentNotValidException exception) {
        log.error("MethodArgumentNotValidException: {}", exception.getMessage());
        return ResponseEntity.badRequest().body(ApiResponse.error("요청 본문이 유효하지 않습니다."));
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse> handle(MissingServletRequestParameterException exception) {
        log.error("MethodArgumentNotValidException: {}", exception.getMessage());
        return ResponseEntity.badRequest().body(ApiResponse.error("필수 파라미터가 누락되었습니다: " + exception.getParameterName()));
    }
}

package com.company.groomingzone.common.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

    INVALID_SIGN_IN(401,"이메일 또는 비밀번호를 확인하세요."),
    UNAUTHORIZED(403, "권한이 없습니다."),
    NOT_SIGN_IN(403, "먼저 로그인 하세요."),;

    private final int status;
    private final String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}

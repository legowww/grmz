package com.company.groomingzone.barber.domain;

import java.util.regex.Pattern;

public record Email(String email) {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$");

    public static Email of(String email) {
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return new Email(email);
    }
}

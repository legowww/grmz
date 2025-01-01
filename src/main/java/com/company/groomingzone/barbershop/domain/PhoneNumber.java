package com.company.groomingzone.barbershop.domain;

import java.util.regex.Pattern;

public record PhoneNumber(
        String phoneNumber
) {
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");

    public static PhoneNumber of(String phoneNumber) {
        if (!PHONE_NUMBER_PATTERN.matcher(phoneNumber).matches()) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        return new PhoneNumber(phoneNumber);
    }
}

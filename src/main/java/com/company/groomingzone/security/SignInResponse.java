package com.company.groomingzone.security;

import java.util.List;

public record SignInResponse(
    Long id,
    String email,
    String name,
    List<String> roles
) {
}

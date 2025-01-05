package com.company.groomingzone.security;

public record SignInRequest(
    String email,
    String password
) {

}

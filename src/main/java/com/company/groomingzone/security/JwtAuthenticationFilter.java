package com.company.groomingzone.security;

import com.company.groomingzone.member.MemberEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;
    private final PasswordEncoder passwordEncoder;

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();
        SignInRequest signInRequest = objectMapper.readValue(request.getInputStream(), SignInRequest.class);
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(signInRequest.email(), signInRequest.password());

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        MemberEntity memberEntity = (MemberEntity) authResult.getPrincipal();

        String accessToken = getAccessTokenFromJwtManager(memberEntity);
        String refreshToken = getRefreshTokenFromJwtManager(memberEntity);

        response.addHeader("Authorization", accessToken);
        response.addHeader("Refresh",refreshToken);

//        redisSignInPort.signIn(memberEntity.getEmail(), accessToken);

        this.getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
    }

    private String getAccessTokenFromJwtManager(MemberEntity memberEntity) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", memberEntity.getEmail());
        claims.put("roles", memberEntity.getRoles());

        String subject = memberEntity.getEmail();
        Date expiration = jwtManager.getTokenExpiration(jwtManager.getAccessTokenExpirationMinutes());
        String base64EncodedSecretKey = jwtManager.encodeBase64SecretKey(jwtManager.getSecretKey());

        return jwtManager.generateAccessToken(claims, subject, expiration, base64EncodedSecretKey);
    }

    private String getRefreshTokenFromJwtManager(MemberEntity memberEntity) {
        String subject = memberEntity.getEmail();
        Date expiration = jwtManager.getTokenExpiration(jwtManager.getRefreshTokenExpirationMinutes());
        String base64EncodedSecretKey = jwtManager.encodeBase64SecretKey(jwtManager.getSecretKey());

        return jwtManager.generateRefreshToken(subject, expiration, base64EncodedSecretKey);
    }
}


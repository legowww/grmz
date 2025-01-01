package com.company.groomingzone.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtVerificationFilter extends OncePerRequestFilter {

    private final JwtManager jwtManager;
    private final CustomAuthorityUtils authorityUtils;
    private final UserDetailsService userDetailsService;

    public JwtVerificationFilter(JwtManager jwtManager, CustomAuthorityUtils authorityUtils, UserDetailsService userDetailsService) {
        this.jwtManager = jwtManager;
        this.authorityUtils = authorityUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String accessToken = request.getHeader("ACCESS-TOKEN");
            jwtManager.verifyToken(accessToken, jwtManager.encodeBase64SecretKey(jwtManager.getSecretKey()));
            Map<String, Object> claims = getClaims(accessToken);
            setAuthenticationToContext(claims);
        } catch (Exception e) {
            request.setAttribute("exception", e);
        }

        filterChain.doFilter(request, response);
    }

    private Claims getClaims(String accessToken) {
        String base64EncodedSecretKey = jwtManager.encodeBase64SecretKey(jwtManager.getSecretKey());
        return jwtManager.getClaims(accessToken, base64EncodedSecretKey).getBody();
    }

    private void setAuthenticationToContext(Map<String, Object> claims) {
        String username = (String) claims.get("email");
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        List<GrantedAuthority> authorities = authorityUtils.createAuthorities((List<String>) claims.get("roles"));

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        if(request.getCookies() != null){
            String accessToken = request.getHeader("ACCESS-TOKEN");
            return accessToken == null || !accessToken.startsWith("Bearer");
        }
        return true;
    }
}

package com.company.groomingzone.security;

import com.company.groomingzone.member.MemberEntity;
import com.company.groomingzone.member.MemberService.MemberDetails;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Slf4j
public class MemberAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final Gson gson = new Gson();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request
        , HttpServletResponse response
        , Authentication authentication) throws IOException{
        MemberDetails memberEntity = (MemberDetails) authentication.getPrincipal();
        Long id = memberEntity.getId();
        String name = memberEntity.getName();
        String email = memberEntity.getEmail();
        SignInResponse signInResponse = new SignInResponse(memberEntity.getId(), memberEntity.getEmail(), memberEntity.getName(), memberEntity.getRoles());

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(gson.toJson(signInResponse));

        log.info("# Authenticated successfully!");
    }
}


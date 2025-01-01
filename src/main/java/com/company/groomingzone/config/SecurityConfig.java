package com.company.groomingzone.config;

import com.company.groomingzone.security.CustomAuthorityUtils;
import com.company.groomingzone.security.JwtAuthenticationFilter;
import com.company.groomingzone.security.JwtManager;
import com.company.groomingzone.security.JwtVerificationFilter;
import com.company.groomingzone.security.MemberAccessDeniedHandler;
import com.company.groomingzone.security.MemberAuthenticationEntryPoint;
import com.company.groomingzone.security.MemberAuthenticationFailureHandler;
import com.company.groomingzone.security.MemberAuthenticationSuccessHandler;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtManager jwtManager;
    private final CustomAuthorityUtils authorityUtils;
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .headers(configurer ->
                configurer
                    .frameOptions(
                        HeadersConfigurer.FrameOptionsConfig::sameOrigin
                    )
            )
            .csrf(AbstractHttpConfigurer::disable)
            .cors(source -> corsConfigurationSource())
            .sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .formLogin(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            .exceptionHandling(handler -> handler
                .accessDeniedHandler(new MemberAccessDeniedHandler())
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())
            )
            .with(new CustomFilterConfigurer(), CustomFilterConfigurer::build)
            .authorizeHttpRequests(authorize -> authorize
                //TODO 권한 설정 할 것들
//                .requestMatchers(HttpMethod.POST, "/free-board/**", "/review/**", "/recruitment/**", "/comment/**").hasRole("CUSTOMER")
//                .requestMatchers(HttpMethod.PUT, "/free-board/**", "/review/**", "/recruitment/**", "/comment/**", "/member/**").hasRole("CUSTOMER")
//                .requestMatchers(HttpMethod.DELETE, "/free-board/**", "/review/**", "/recruitment/**", "/comment/**", "/member/**").hasRole("CUSTOMER")
//
//                .requestMatchers(HttpMethod.POST, "/barber-shop/**").hasRole("BARBER")
//                .requestMatchers(HttpMethod.PUT, "/barber-shop/**").hasRole("BARBER")
//                .requestMatchers(HttpMethod.DELETE, "/barber-shop/**").hasRole("BARBER")

                .anyRequest().permitAll()
            );

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("https://grooming-zone.com", "http://localhost:3000", "http://localhost:8080"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.addAllowedHeader("*");
        configuration.setExposedHeaders(Arrays.asList("Authorization", "Refresh"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtManager);

            jwtAuthenticationFilter.setFilterProcessesUrl("/auth/sign-in");

            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());


            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtManager, authorityUtils, userDetailsService);

            builder
                .addFilter(jwtAuthenticationFilter)
                .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);
        }

        public void build() {
        }
    }
}

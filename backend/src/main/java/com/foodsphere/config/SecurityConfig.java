package com.foodsphere.config;

import com.foodsphere.security.JwtTokenValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenValidator jwtTokenValidator;
    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("Configuring security filter chain.");
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors ->
                        cors.configurationSource(corsConfig.corsConfigurationSource()))
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(
                                "/tests/**",
                                        "/auth/**",
                                        "/health",
                                        "/v3/api-docs/**",
                                        "/swagger-ui/**"
                        ).permitAll()
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "RESTAURANT_OWNER")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtTokenValidator, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
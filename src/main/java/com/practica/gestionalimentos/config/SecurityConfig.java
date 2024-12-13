package com.practica.gestionalimentos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/h2-console/**").permitAll()  // Permitir acceso público a la página de inicio y H2 Console
                        .anyRequest().authenticated()  // Requerir autenticación para cualquier otra ruta
                )
                .csrf(csrf -> csrf.disable())  // Deshabilitar protección CSRF (necesario para H2 Console)
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));  // Permitir que la consola H2 funcione en marcos

        return http.build();
    }
}

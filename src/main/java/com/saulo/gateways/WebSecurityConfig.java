package com.saulo.gateways;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // require all requests to be authenticated except for the resources
        http.authorizeHttpRequests((requests)->requests.anyRequest().permitAll());
        // not needed as JSF 2.2 is implicitly protected against CSRF
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}

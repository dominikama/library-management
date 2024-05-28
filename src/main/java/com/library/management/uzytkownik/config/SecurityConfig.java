package com.library.management.uzytkownik.config;

import com.library.management.uzytkownik.services.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The type Security config.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UzytkownikService uzytkownikService;
    private final JwtRequestFilter jwtRequestFilter;

    /**
     * Instantiates a new Security config.
     *
     * @param uzytkownikService the uzytkownik service
     * @param jwtRequestFilter  the jwt request filter
     */
    @Autowired
    public SecurityConfig(@Lazy UzytkownikService uzytkownikService, JwtRequestFilter jwtRequestFilter) {
        this.uzytkownikService = uzytkownikService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    /**
     * Password encoder password encoder.
     *
     * @return the password encoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Authentication provider authentication provider.
     *
     * @return the authentication provider
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(uzytkownikService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Authentication manager authentication manager.
     *
     * @param config the config
     * @return the authentication manager
     * @throws Exception the exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * Security filter chain security filter chain.
     *
     * @param http the http
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/register", "/auth/login").permitAll()
                        .requestMatchers("/autorzy/**", "/wydawnictwa/**", "/zamowienia/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/ksiazki").hasAnyRole("USER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/ksiazki/status").hasAnyRole("USER", "EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/ksiazki").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/ksiazki/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/rezerwacje").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/rezerwacje").hasRole("USER")
                        .requestMatchers(HttpMethod.DELETE, "/rezerwacje/**").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

package com.library.management.uzytkownik.controller;

import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.uzytkownik.config.JWTUtil;
import com.library.management.uzytkownik.services.UzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UzytkownikService uzytkownikService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Register uzytkownik.
     *
     * @param user the user
     * @return the uzytkownik
     */
    @PostMapping("/register")
    public Uzytkownik register(@RequestBody Uzytkownik user) {
        return uzytkownikService.rejestracjaUzytkownika(user);
    }

    /**
     * Login response entity.
     *
     * @param loginRequest the login request
     * @return the response entity
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = jwtUtil.generateToken(userDetails.getUsername(), userDetails.getAuthorities().iterator().next().getAuthority());
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}

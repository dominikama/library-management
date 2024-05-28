package com.library.management.uzytkownik.controller;

/**
 * The type Jwt response.
 */
public class JwtResponse {

    private final String jwt;

    /**
     * Instantiates a new Jwt response.
     *
     * @param jwt the jwt
     */
    public JwtResponse(String jwt) {
        this.jwt = jwt;
    }

    /**
     * Gets jwt.
     *
     * @return the jwt
     */
    public String getJwt() {
        return jwt;
    }
}


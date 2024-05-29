package com.library.management.uzytkownik.services;

import com.library.management.uzytkownik.Uzytkownik;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * The interface Uzytkownik service.
 */
public interface UzytkownikService extends UserDetailsService
{
    /**
     * Rejestracja uzytkownika uzytkownik.
     *
     * @param uzytkownik the uzytkownik
     * @return the uzytkownik
     */
    Uzytkownik rejestracjaUzytkownika(Uzytkownik uzytkownik);

    /**
     * Find by username uzytkownik.
     *
     * @param username the username
     * @return the uzytkownik
     */
    Uzytkownik findByUsername(String username);
}

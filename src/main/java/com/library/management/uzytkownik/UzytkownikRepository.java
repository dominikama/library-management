package com.library.management.uzytkownik;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Uzytkownik repository.
 */
public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Integer> {
    /**
     * Find by username optional.
     *
     * @param username the username
     * @return the optional
     */
    Optional<Uzytkownik> findByUsername(String username);

}

package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.Wydawnictwo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Wydawnictwo repository.
 */
public interface WydawnictwoRepository extends JpaRepository<Wydawnictwo, Integer> {
    /**
     * Find by wydawnictwo nazwa optional.
     *
     * @param wydawnictwoNazwa the wydawnictwo nazwa
     * @return the optional
     */
    Optional<Wydawnictwo> findByWydawnictwoNazwa(String wydawnictwoNazwa);
}

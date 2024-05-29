package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.Autor;
import com.library.management.ksiazka.entities.DaneKsiazki;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

/**
 * The interface Dane ksiazki repository.
 */
public interface DaneKsiazkiRepository extends JpaRepository<DaneKsiazki, Integer> {
    /**
     * Find by tytul and rok wydania and autorzy in optional.
     *
     * @param tytul      the tytul
     * @param rokWydania the rok wydania
     * @param autorzy    the autorzy
     * @return the optional
     */
    Optional<DaneKsiazki> findByTytulAndRokWydaniaAndAutorzyIn(String tytul, Integer rokWydania, Set<Autor> autorzy);
}

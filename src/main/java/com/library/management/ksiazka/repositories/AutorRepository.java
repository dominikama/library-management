package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Autor repository.
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    /**
     * Find by imie and nazwisko optional.
     *
     * @param imie     the imie
     * @param nazwisko the nazwisko
     * @return the optional
     */
    Optional<Autor> findByImieAndNazwisko(String imie, String nazwisko);
}

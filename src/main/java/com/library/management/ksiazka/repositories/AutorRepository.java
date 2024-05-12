package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    Optional<Autor> findByImieAndNazwisko(String imie, String nazwisko);
}

package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.Autor;
import com.library.management.ksiazka.entities.DaneKsiazki;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DaneKsiazkiRepository extends JpaRepository<DaneKsiazki, Integer> {
    Optional<DaneKsiazki> findByTytulAndRokWydaniaAndAutorzyIn(String tytul, Integer rokWydania, Set<Autor> autorzy);
}

package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.Wydawnictwo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WydawnictwoRepository extends JpaRepository<Wydawnictwo, Integer> {
    Optional<Wydawnictwo> findByWydawnictwoNazwa(String wydawnictwoNazwa);
}

package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.DaneKsiazki;
import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.ksiazka.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KsiazkaRepository extends JpaRepository<Ksiazka, Integer> {
    List<Ksiazka> findAllByStatus(Status status);
    List<Ksiazka> findAllByDaneKsiazki(DaneKsiazki daneKsiazki);
}

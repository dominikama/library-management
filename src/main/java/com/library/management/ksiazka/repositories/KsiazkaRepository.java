package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.DaneKsiazki;
import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.ksiazka.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KsiazkaRepository extends JpaRepository<Ksiazka, Integer> {

    Integer countByDaneKsiazkiAndStatus(DaneKsiazki daneKsiazki, Status status);

}

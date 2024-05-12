package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.DaneKsiazki;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaneKsiazkiRepository extends JpaRepository<DaneKsiazki, Integer> {
}

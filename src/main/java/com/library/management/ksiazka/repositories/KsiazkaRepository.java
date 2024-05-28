package com.library.management.ksiazka.repositories;

import com.library.management.ksiazka.entities.DaneKsiazki;
import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.ksiazka.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Ksiazka repository.
 */
public interface KsiazkaRepository extends JpaRepository<Ksiazka, Integer> {

    /**
     * Count by dane ksiazki and status integer.
     *
     * @param daneKsiazki the dane ksiazki
     * @param status      the status
     * @return the integer
     */
    Integer countByDaneKsiazkiAndStatus(DaneKsiazki daneKsiazki, Status status);

}

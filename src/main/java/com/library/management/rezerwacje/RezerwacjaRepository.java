package com.library.management.rezerwacje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Rezerwacja repository.
 */
@Repository
public interface RezerwacjaRepository extends JpaRepository<Rezerwacja, Integer> {
}

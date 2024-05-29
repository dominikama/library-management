package com.library.management.zamowienia.repository;

import com.library.management.zamowienia.entities.Zamowienie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Zamowienie repository.
 */
public interface ZamowienieRepository extends JpaRepository<Zamowienie, Integer> {
}

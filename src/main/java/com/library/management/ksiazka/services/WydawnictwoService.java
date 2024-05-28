package com.library.management.ksiazka.services;

import com.library.management.ksiazka.entities.Wydawnictwo;

import java.util.List;

/**
 * The interface Wydawnictwo service.
 */
public interface WydawnictwoService {
    /**
     * Dodaj wydawnictwo wydawnictwo.
     *
     * @param wydawnictwo the wydawnictwo
     * @return the wydawnictwo
     */
    Wydawnictwo dodajWydawnictwo(Wydawnictwo wydawnictwo);

    /**
     * Wszystkie wydawnictwa list.
     *
     * @return the list
     */
    List<Wydawnictwo> wszystkieWydawnictwa();
}

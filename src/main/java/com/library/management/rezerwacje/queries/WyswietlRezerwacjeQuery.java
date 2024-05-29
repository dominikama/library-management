package com.library.management.rezerwacje.queries;

import com.library.management.rezerwacje.Rezerwacja;

import java.util.List;

/**
 * The interface Wyswietl rezerwacje query.
 */
public interface WyswietlRezerwacjeQuery {
    /**
     * Wyswietl list.
     *
     * @return the list
     */
    List<Rezerwacja> wyswietl();
}

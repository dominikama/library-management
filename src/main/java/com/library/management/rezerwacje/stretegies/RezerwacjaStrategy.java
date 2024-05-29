package com.library.management.rezerwacje.stretegies;

import com.library.management.rezerwacje.Rezerwacja;

import java.util.List;

/**
 * The interface Rezerwacja strategy.
 */
public interface RezerwacjaStrategy {
    /**
     * Stworz rezerwacje rezerwacja.
     *
     * @param listKsiazek  the list ksiazek
     * @param uzytkownikId the uzytkownik id
     * @return the rezerwacja
     */
    Rezerwacja stworzRezerwacje(List<Integer> listKsiazek, int uzytkownikId);

    /**
     * Gets typ.
     *
     * @return the typ
     */
    Typ getTyp();
}

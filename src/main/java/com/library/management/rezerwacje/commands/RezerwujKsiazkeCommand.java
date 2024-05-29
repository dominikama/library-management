package com.library.management.rezerwacje.commands;

import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.rezerwacje.RezerwacjaRequest;

/**
 * The interface Rezerwuj ksiazke command.
 */
public interface RezerwujKsiazkeCommand {
    /**
     * Rezerwuj rezerwacja.
     *
     * @param rezerwacjaRequest the rezerwacja request
     * @return the rezerwacja
     */
    Rezerwacja rezerwuj(RezerwacjaRequest rezerwacjaRequest);
}

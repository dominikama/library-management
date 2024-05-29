package com.library.management.rezerwacje.commands;

import com.library.management.rezerwacje.Rezerwacja;

/**
 * The interface Odwolaj rezerwacje command.
 */
public interface OdwolajRezerwacjeCommand {
    /**
     * Odwolaj rezerwacja.
     *
     * @param rezerwacjaId the rezerwacja id
     * @return the rezerwacja
     */
    Rezerwacja odwolaj(int rezerwacjaId);
}

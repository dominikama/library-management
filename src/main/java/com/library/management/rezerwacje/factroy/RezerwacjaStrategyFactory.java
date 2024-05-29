package com.library.management.rezerwacje.factroy;

import com.library.management.rezerwacje.stretegies.RezerwacjaStrategy;
import com.library.management.rezerwacje.stretegies.Typ;

/**
 * The interface Rezerwacja strategy factory.
 */
public interface RezerwacjaStrategyFactory {
    /**
     * Gets rezerwacja strategy.
     *
     * @param typ the typ
     * @return the rezerwacja strategy
     */
    RezerwacjaStrategy getRezerwacjaStrategy(Typ typ);
}

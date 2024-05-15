package com.library.management.rezerwacje.factroy;

import com.library.management.rezerwacje.stretegies.RezerwacjaStrategy;
import com.library.management.rezerwacje.stretegies.Typ;

public interface RezerwacjaStrategyFactory {
    RezerwacjaStrategy getRezerwacjaStrategy(Typ typ);
}

package com.library.management.rezerwacje.stretegies.implementation;

import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.rezerwacje.stretegies.RezerwacjaStrategy;
import org.springframework.stereotype.Component;

@Component
public class PriorytetRezerwacjaStrategy implements RezerwacjaStrategy {
    @Override
    public Rezerwacja rezerwuj(int ksiazkaId, int uzytkownikId) {
        return null;
    }
}

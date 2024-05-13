package com.library.management.rezerwacje.stretegies;

import com.library.management.rezerwacje.Rezerwacja;

public interface RezerwacjaStrategy {
    Rezerwacja rezerwuj(int ksiazkaId, int uzytkownikId);
}

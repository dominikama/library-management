package com.library.management.rezerwacje.stretegies;

import com.library.management.rezerwacje.Rezerwacja;

import java.util.List;

public interface RezerwacjaStrategy {
    Rezerwacja stworzRezerwacje(List<Integer> listKsiazek, int uzytkownikId);
    Typ getTyp();
}

package com.library.management.ksiazka.services;

import com.library.management.ksiazka.entities.Wydawnictwo;

import java.util.List;

public interface WydawnictwoService {
    Wydawnictwo dodajWydawnictwo(Wydawnictwo wydawnictwo);

    List<Wydawnictwo> wszystkieWydawnictwa();
}

package com.library.management.ksiazka.services;

import com.library.management.ksiazka.entities.Ksiazka;

import java.util.List;

public interface KsiazkaService {
    Ksiazka dodajKsiazke(Ksiazka ksiazka);

    List<Ksiazka> wyswietlKsiazki();

    List<Ksiazka> wyswietlKsiazkiOdanymStatusie(String inputStatus);

    Ksiazka wydajKsiazke(int ksiazkaId);

    Ksiazka odbierzKsiazke(int ksiazkaId);

}

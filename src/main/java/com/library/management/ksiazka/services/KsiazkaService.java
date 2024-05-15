package com.library.management.ksiazka.services;

import com.library.management.ksiazka.controller.dtos.KsiazkaRequestDTO;
import com.library.management.ksiazka.controller.dtos.KsiazkaResponseDTO;
import com.library.management.ksiazka.entities.DaneKsiazki;
import com.library.management.ksiazka.entities.Ksiazka;

import java.util.List;

public interface KsiazkaService {
    KsiazkaResponseDTO dodajKsiazke(KsiazkaRequestDTO ksiazka);

    List<Ksiazka> wyswietlKsiazki();

    List<Ksiazka> wyswietlKsiazkiOdanymStatusie(String inputStatus);

    KsiazkaResponseDTO wydajKsiazke(int ksiazkaId);

    KsiazkaResponseDTO odbierzKsiazke(int ksiazkaId);

}

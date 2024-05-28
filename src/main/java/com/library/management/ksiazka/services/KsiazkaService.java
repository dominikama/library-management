package com.library.management.ksiazka.services;

import com.library.management.ksiazka.controller.dtos.KsiazkaRequestDTO;
import com.library.management.ksiazka.controller.dtos.KsiazkaResponseDTO;
import com.library.management.ksiazka.entities.Ksiazka;

import java.util.List;

/**
 * The interface Ksiazka service.
 */
public interface KsiazkaService {
    /**
     * Dodaj ksiazke ksiazka response dto.
     *
     * @param ksiazka the ksiazka
     * @return the ksiazka response dto
     */
    KsiazkaResponseDTO dodajKsiazke(KsiazkaRequestDTO ksiazka);

    /**
     * Wyswietl ksiazki list.
     *
     * @return the list
     */
    List<Ksiazka> wyswietlKsiazki();

    /**
     * Wyswietl ksiazki odanym statusie list.
     *
     * @param inputStatus the input status
     * @return the list
     */
    List<Ksiazka> wyswietlKsiazkiOdanymStatusie(String inputStatus);

    /**
     * Wydaj ksiazke ksiazka response dto.
     *
     * @param ksiazkaId the ksiazka id
     * @return the ksiazka response dto
     */
    KsiazkaResponseDTO wydajKsiazke(int ksiazkaId);

    /**
     * Odbierz ksiazke ksiazka response dto.
     *
     * @param ksiazkaId the ksiazka id
     * @return the ksiazka response dto
     */
    KsiazkaResponseDTO odbierzKsiazke(int ksiazkaId);

}

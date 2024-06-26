package com.library.management.ksiazka.controller;

import com.library.management.ksiazka.controller.dtos.KsiazkaRequestDTO;
import com.library.management.ksiazka.controller.dtos.KsiazkaResponseDTO;
import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.ksiazka.services.KsiazkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The type Ksiazka controller.
 */
@RestController
@RequestMapping("/ksiazki")
public class KsiazkaController {

    @Autowired
    private KsiazkaService ksiazkaService;

    /**
     * Dodaj ksiazke returns response dto.
     *
     * @param ksiazka the ksiazka
     * @return the ksiazka response dto
     */
    @PostMapping
    public KsiazkaResponseDTO dodajKsiazke(@RequestBody KsiazkaRequestDTO ksiazka) {
        return ksiazkaService.dodajKsiazke(ksiazka);
    }

    /**
     * Wyswietl ksiazki list.
     *
     * @param status the status
     * @return the list
     */
    @GetMapping
    public List<Ksiazka> wyswietlKsiazki(@RequestParam(required = false) String status) {
        if (status != null) {
            return ksiazkaService.wyswietlKsiazkiOdanymStatusie(status);
        } else {
            return ksiazkaService.wyswietlKsiazki();
        }
    }

    /**
     * Wydaj ksiazke ksiazka response dto.
     *
     * @param ksiazkaId the ksiazka id
     * @return the ksiazka response dto
     */
    @PutMapping("/{ksiazkaId}")
    public KsiazkaResponseDTO wydajKsiazke(@PathVariable int ksiazkaId) {
        return ksiazkaService.wydajKsiazke(ksiazkaId);
    }

    /**
     * Odbierz ksiazke ksiazka response dto.
     *
     * @param ksiazkaId the ksiazka id
     * @return the ksiazka response dto
     */
    @PutMapping("/odbierz/{ksiazkaId}")
    public KsiazkaResponseDTO odbierzKsiazke(@PathVariable int ksiazkaId) {
        return ksiazkaService.odbierzKsiazke(ksiazkaId);
    }
}


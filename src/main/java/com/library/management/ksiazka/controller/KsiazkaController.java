package com.library.management.ksiazka.controller;

import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.ksiazka.services.KsiazkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ksiazki")
public class KsiazkaController {

    @Autowired
    private KsiazkaService ksiazkaService;

    @PostMapping
    public Ksiazka dodajKsiazke(@RequestBody Ksiazka ksiazka) {
        return ksiazkaService.dodajKsiazke(ksiazka);
    }

    @GetMapping
    public List<Ksiazka> wyswietlKsiazki(@RequestParam(required = false) String status) {
        if (status != null) {
            return ksiazkaService.wyswietlKsiazkiOdanymStatusie(status);
        } else {
            return ksiazkaService.wyswietlKsiazki();
        }
    }
    @PutMapping("/{ksiazkaId}")
    public Ksiazka wydajKsiazke(@PathVariable int ksiazkaId) {
        return ksiazkaService.wydajKsiazke(ksiazkaId);
    }

    @PutMapping("/odbierz/{ksiazkaId}")
    public Ksiazka odbierzKsiazke(@PathVariable int ksiazkaId) {
        return ksiazkaService.odbierzKsiazke(ksiazkaId);
    }
}


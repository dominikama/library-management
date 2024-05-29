package com.library.management.ksiazka.controller;

import com.library.management.ksiazka.entities.Wydawnictwo;
import com.library.management.ksiazka.services.WydawnictwoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Wydawnictwo controller.
 */
@RestController
@RequestMapping("/wydawnictwa")
public class WydawnictwoController {
    private WydawnictwoService wydawnictwoService;

    /**
     * Instantiates a new Wydawnictwo controller.
     *
     * @param wydawnictwoService the wydawnictwo service
     */
    public WydawnictwoController(WydawnictwoService wydawnictwoService) {
        this.wydawnictwoService = wydawnictwoService;
    }

    /**
     * Dodaj wydawnictwo wydawnictwo.
     *
     * @param wydawnictwo the wydawnictwo
     * @return the wydawnictwo
     */
    @PostMapping
    public Wydawnictwo dodajWydawnictwo(@RequestBody Wydawnictwo wydawnictwo) {
        return wydawnictwoService.dodajWydawnictwo(wydawnictwo);
    }

    /**
     * Wszystkie wydawnictwa list.
     *
     * @return the list
     */
    @GetMapping
    public List<Wydawnictwo> wszystkieWydawnictwa() {
        return wydawnictwoService.wszystkieWydawnictwa();
    }
}

package com.library.management.ksiazka.controller;

import com.library.management.ksiazka.entities.Autor;
import com.library.management.ksiazka.services.AutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Autor controller.
 */
@RestController
@RequestMapping("/autorzy")
public class AutorController {

    private AutorService autorService;

    /**
     * Instantiates a new Autor controller.
     *
     * @param autorService the autor service
     */
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    /**
     * Dodaj autora autor.
     *
     * @param autor the autor
     * @return the autor
     */
    @PostMapping
    public Autor dodajAutora(@RequestBody Autor autor) {
        return autorService.dodajAutora(autor);
    }

    /**
     * Wszyscy autorzy list.
     *
     * @return the list
     */
    @GetMapping
    public List<Autor> wszyscyAutorzy() {
        return autorService.wszyscyAutorzy();
    }
}

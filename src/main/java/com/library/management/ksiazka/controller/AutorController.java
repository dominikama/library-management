package com.library.management.ksiazka.controller;

import com.library.management.ksiazka.entities.Autor;
import com.library.management.ksiazka.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autorzy")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public Autor dodajAutora(@RequestBody Autor autor) {
        return autorService.dodajAutora(autor);
    }

    @GetMapping
    public List<Autor> wszyscyAutorzy() {
        return autorService.wszyscyAutorzy();
    }
}

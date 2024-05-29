package com.library.management.zamowienia.controller;

import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.uzytkownik.services.UzytkownikService;
import com.library.management.zamowienia.entities.Zamowienie;
import com.library.management.zamowienia.service.ZamowienieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Zamowienie controller.
 */
@RestController
@RequestMapping("/zamowienia")
public class ZamowienieController {
    @Autowired
    private ZamowienieService zamowienieService;

    @Autowired
    private UzytkownikService uzytkownikService;

    /**
     * Create zamowienie response entity.
     *
     * @param zamowienieRequest the zamowienie request
     * @param authentication    the authentication
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<Zamowienie> createZamowienie(@RequestBody ZamowienieRequest zamowienieRequest, Authentication authentication) {
        String username = authentication.getName();
        Uzytkownik uzytkownik = uzytkownikService.findByUsername(username);

        Zamowienie zamowienie = zamowienieService.createZamowienie(zamowienieRequest, uzytkownik);
        return ResponseEntity.ok(zamowienie);
    }

    /**
     * Gets all.
     *
     * @return  all zamowienia
     */
    @GetMapping
    public List<Zamowienie> getAll() {
        return zamowienieService.getAll();
    }
}


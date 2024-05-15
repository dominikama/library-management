package com.library.management.rezerwacje;

import com.library.management.rezerwacje.commands.OdwolajRezerwacjeCommand;
import com.library.management.rezerwacje.commands.RezerwujKsiazkeCommand;
import com.library.management.rezerwacje.queries.WyswietlRezerwacjeQuery;
import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.uzytkownik.UzytkownikRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rezerwacje")
public class RezerwacjaController {

    private RezerwujKsiazkeCommand rezerwujKsiazkeCommand;

    private OdwolajRezerwacjeCommand odwolajRezerwacje;

    private WyswietlRezerwacjeQuery wyswietlRezerwacjeQuery;

    private UzytkownikRepository uzytkownikRepository;

    public RezerwacjaController(RezerwujKsiazkeCommand rezerwujKsiazkeCommand, OdwolajRezerwacjeCommand odwolajRezerwacje,
                                WyswietlRezerwacjeQuery wyswietlRezerwacjeQuery) {
        this.rezerwujKsiazkeCommand = rezerwujKsiazkeCommand;
        this.odwolajRezerwacje = odwolajRezerwacje;
        this.wyswietlRezerwacjeQuery = wyswietlRezerwacjeQuery;
    }

    @PostMapping
    public Rezerwacja rezerwujKsiazke(@RequestBody RezerwacjaRequest rezerwacja) {
        return rezerwujKsiazkeCommand.rezerwuj(rezerwacja);
    }

    @DeleteMapping("/{rezerwacjaId}")
    public Rezerwacja odwolajRzerwcaje(@PathVariable int rezerwacjaId) {
        return odwolajRezerwacje.odwolaj(rezerwacjaId);
    }

    @GetMapping
    public List<Rezerwacja> wyswiwetlRezerwacje() {
        return wyswietlRezerwacjeQuery.wyswietl();
    }
}

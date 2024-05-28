package com.library.management.rezerwacje;

import com.library.management.rezerwacje.commands.OdwolajRezerwacjeCommand;
import com.library.management.rezerwacje.commands.RezerwujKsiazkeCommand;
import com.library.management.rezerwacje.queries.WyswietlRezerwacjeQuery;
import com.library.management.uzytkownik.UzytkownikRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Rezerwacja controller.
 */
@RestController
@RequestMapping("/rezerwacje")
public class RezerwacjaController {

    private RezerwujKsiazkeCommand rezerwujKsiazkeCommand;

    private OdwolajRezerwacjeCommand odwolajRezerwacje;

    private WyswietlRezerwacjeQuery wyswietlRezerwacjeQuery;

    private UzytkownikRepository uzytkownikRepository;

    /**
     * Instantiates a new Rezerwacja controller.
     *
     * @param rezerwujKsiazkeCommand  the rezerwuj ksiazke command
     * @param odwolajRezerwacje       the odwolaj rezerwacje
     * @param wyswietlRezerwacjeQuery the wyswietl rezerwacje query
     */
    public RezerwacjaController(RezerwujKsiazkeCommand rezerwujKsiazkeCommand, OdwolajRezerwacjeCommand odwolajRezerwacje,
                                WyswietlRezerwacjeQuery wyswietlRezerwacjeQuery) {
        this.rezerwujKsiazkeCommand = rezerwujKsiazkeCommand;
        this.odwolajRezerwacje = odwolajRezerwacje;
        this.wyswietlRezerwacjeQuery = wyswietlRezerwacjeQuery;
    }

    /**
     * Rezerwuj ksiazke rezerwacja.
     *
     * @param rezerwacja the rezerwacja
     * @return the rezerwacja
     */
    @PostMapping
    public Rezerwacja rezerwujKsiazke(@RequestBody RezerwacjaRequest rezerwacja) {
        return rezerwujKsiazkeCommand.rezerwuj(rezerwacja);
    }

    /**
     * Odwolaj rzerwcaje rezerwacja.
     *
     * @param rezerwacjaId the rezerwacja id
     * @return the rezerwacja
     */
    @DeleteMapping("/{rezerwacjaId}")
    public Rezerwacja odwolajRzerwcaje(@PathVariable int rezerwacjaId) {
        return odwolajRezerwacje.odwolaj(rezerwacjaId);
    }

    /**
     * Wyswiwetl rezerwacje list.
     *
     * @return the list
     */
    @GetMapping
    public List<Rezerwacja> wyswiwetlRezerwacje() {
        return wyswietlRezerwacjeQuery.wyswietl();
    }
}

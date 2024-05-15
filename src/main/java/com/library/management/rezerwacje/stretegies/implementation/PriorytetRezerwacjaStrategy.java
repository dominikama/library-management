package com.library.management.rezerwacje.stretegies.implementation;

import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.ksiazka.entities.Status;
import com.library.management.ksiazka.repositories.KsiazkaRepository;
import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.rezerwacje.stretegies.RezerwacjaStrategy;
import com.library.management.rezerwacje.stretegies.Typ;
import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.uzytkownik.UzytkownikRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PriorytetRezerwacjaStrategy implements RezerwacjaStrategy {

    private UzytkownikRepository uzytkownikRepository;

    private KsiazkaRepository ksiazkaRepository;

    public PriorytetRezerwacjaStrategy(UzytkownikRepository uzytkownikRepository, KsiazkaRepository ksiazkaRepository) {
        this.uzytkownikRepository = uzytkownikRepository;
        this.ksiazkaRepository = ksiazkaRepository;
    }

    @Override
    public Rezerwacja stworzRezerwacje(List<Integer> listKsiazek, int uzytkownikId) {
        Rezerwacja rezerwacja = new Rezerwacja();
        Uzytkownik uzytkownik = uzytkownikRepository.findById(uzytkownikId)
                .orElseThrow(() -> new IllegalArgumentException("Taki uzytkownik nie istnieje"));
        rezerwacja.setUzytkownik(uzytkownik);
        LocalDateTime start = LocalDateTime.now();
        rezerwacja.setStartRezerwacja(start);
        rezerwacja.setKoniecRezerwacja(start.plusDays(1));
        rezerwacja.setKsiazki(populujKsiazki(listKsiazek));
        return rezerwacja;
    }

    private Set<Ksiazka> populujKsiazki(List<Integer> ksiazkiId) {
        Set<Ksiazka> ksiazkiZarezerwowane = new HashSet<>();
        for (Integer id : ksiazkiId) {
            Ksiazka ksiazka = ksiazkaRepository.findById(id).orElseThrow(() ->
                    new IllegalArgumentException("Nie ma takiej ksiazki"));
            ksiazka.setStatus(Status.ZAREZERWOWANA_PRIORYTET);
            ksiazkiZarezerwowane.add(ksiazka);
        }
        return ksiazkiZarezerwowane;
    }
    @Override
    public Typ getTyp() {
        return Typ.PRIORYTET;
    }
}

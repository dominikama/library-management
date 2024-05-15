package com.library.management.rezerwacje.commands.implementation;

import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.ksiazka.entities.Status;
import com.library.management.ksiazka.repositories.KsiazkaRepository;
import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.rezerwacje.RezerwacjaRepository;
import com.library.management.rezerwacje.commands.OdwolajRezerwacjeCommand;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DefaultOdwolajRezerwacjeCommand implements OdwolajRezerwacjeCommand {

    private RezerwacjaRepository rezerwacjaRepository;

    private KsiazkaRepository ksiazkaRepository;


    public DefaultOdwolajRezerwacjeCommand(RezerwacjaRepository rezerwacjaRepository,
                                           KsiazkaRepository ksiazkaRepository) {
        this.rezerwacjaRepository = rezerwacjaRepository;
        this.ksiazkaRepository = ksiazkaRepository;
    }

    @Override
    public Rezerwacja odwolaj(int rezerwacjaId) {
        Rezerwacja rezerwacja = rezerwacjaRepository.findById(rezerwacjaId)
                .orElseThrow(() -> new IllegalArgumentException("Rzerewacja nie znaleziona"));
        Set<Ksiazka> zarezerwowaneKsiazki = rezerwacja.getKsiazki();
        for (Ksiazka ksiazka : zarezerwowaneKsiazki) {
            ksiazka.setStatus(Status.DOSTEPNA);
            ksiazkaRepository.save(ksiazka);
        }
        rezerwacjaRepository.delete(rezerwacja);
        return rezerwacja;
    }
}

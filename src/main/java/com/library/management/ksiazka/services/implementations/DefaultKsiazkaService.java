package com.library.management.ksiazka.services.implementations;

import com.library.management.ksiazka.entities.*;
import com.library.management.ksiazka.repositories.AutorRepository;
import com.library.management.ksiazka.repositories.DaneKsiazkiRepository;
import com.library.management.ksiazka.repositories.KsiazkaRepository;
import com.library.management.ksiazka.repositories.WydawnictwoRepository;
import com.library.management.ksiazka.services.KsiazkaService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DefaultKsiazkaService implements KsiazkaService {

    private KsiazkaRepository ksiazkaRepository;

    private DaneKsiazkiRepository daneKsiazkiRepository;

    private AutorRepository autorRepository;

    private WydawnictwoRepository wydawnictwoRepository;

    public DefaultKsiazkaService(KsiazkaRepository ksiazkaRepository, DaneKsiazkiRepository daneKsiazkiRepository,
                                 AutorRepository autorRepository, WydawnictwoRepository wydawnictwoRepository) {
        this.ksiazkaRepository = ksiazkaRepository;
        this.daneKsiazkiRepository = daneKsiazkiRepository;
        this.autorRepository = autorRepository;
        this.wydawnictwoRepository = wydawnictwoRepository;
    }

    @Override
    public Ksiazka dodajKsiazke(Ksiazka ksiazka) {
        DaneKsiazki zapisane = zapiszDaneKsiazki(ksiazka.getDaneKsiazki());
        ksiazka.setDaneKsiazki(zapisane);
        Set<Autor> przetworzeniAutorzy = zapiszAutorow(ksiazka.getAutorzy());
        ksiazka.setAutorzy(przetworzeniAutorzy);
        ksiazka.setStatus(Status.DOSTEPNA);
        return ksiazkaRepository.save(ksiazka);
    }

    @Override
    public List<Ksiazka> wyswietlKsiazki() {
        return ksiazkaRepository.findAll();
    }

    @Override
    public List<Ksiazka> wyswietlKsiazkiOdanymStatusie(String inputStatus) {
        Status status = Status.valueOf(inputStatus);
        return ksiazkaRepository.findAllByStatus(status).stream().filter(k -> k.getIlosc() > 0).toList();
    }

    @Override
    public Ksiazka wydajKsiazke(int ksiazkaId) {
        Ksiazka doWydania = ksiazkaRepository.findById(ksiazkaId)
                .orElseThrow(() -> new IllegalArgumentException("Ksiazka not found"));
        if (!(doWydania.getIlosc() > 0)) {
            throw new IllegalArgumentException("Ksiazka nie jest dostepna!");
        }
        //zmniejsz ilosc dostepnych ksiazek
        zmniejszIlosc(doWydania);

        //znajdz w tabeli ksiazke z tymi danymi ze statusem WYDANA, jesli obecna zwieksz ilosc, jesli nie dodaj do tabeli
        ksiazkaRepository.findAllByDaneKsiazki(doWydania.getDaneKsiazki())
                .stream().filter(ksiazka -> Status.WYDANA.equals(ksiazka.getStatus()))
                .findFirst()
                .ifPresentOrElse(this::zwiekszIlosc, () ->
                        utworzKsiazke(doWydania.getDaneKsiazki(), doWydania.getAutorzy()));
        return doWydania;
    }

    @Override
    public Ksiazka odbierzKsiazke(int ksiazkaId) {
        Ksiazka doOdebrania = ksiazkaRepository.findById(ksiazkaId)
                .orElseThrow(() -> new IllegalArgumentException("Ksiazka nie znaleziona"));
        if (!(doOdebrania.getIlosc() > 0)) {
            throw new IllegalArgumentException("Ksiazka nie jest dostepna!");
        }
        //zmniejsz ilosc wydanych ksiazek
       zmniejszIlosc(doOdebrania);

        //znajdz w tabeli ksiazke z tymi danymi ze statusem WYDANA i zmniejsz ilosc
        ksiazkaRepository.findAllByDaneKsiazki(doOdebrania.getDaneKsiazki())
                .stream().filter(ksiazka -> Status.DOSTEPNA.equals(ksiazka.getStatus()))
                .findFirst()
                .ifPresentOrElse(this::zmniejszIlosc, () ->
                        new IllegalArgumentException("Ksiazka ze statusem dostepna powinna byc obecna"));
        return doOdebrania;
    }

    private DaneKsiazki zapiszDaneKsiazki(DaneKsiazki daneKsiazki) {
        //zapisz wydawnictwo
        Wydawnictwo przetworzoneWydawnictwo = daneKsiazki.getWydawnictwo();
        Wydawnictwo zapisane = wydawnictwoRepository.findByWydawnictwoNazwa(przetworzoneWydawnictwo.getWydawnictwoNazwa())
                .orElseGet(() -> wydawnictwoRepository.save(przetworzoneWydawnictwo));
        daneKsiazki.setWydawnictwo(zapisane);
        //zapisz dane ksiazki
        return daneKsiazkiRepository.save(daneKsiazki);
    }

    private Set<Autor> zapiszAutorow(Set<Autor> autorzy) {
        //zapisz autorów
        Set<Autor> przetworzeniAutorzy = new HashSet<>();
        for (Autor autor : autorzy) {
            Autor zapisanyAutor = autorRepository
                    .findByImieAndNazwisko(autor.getImie(), autor.getNazwisko())
                    .orElseGet(() -> autorRepository.save(autor)); // Zapisz nowego autora, jeśli nie istnieje
            przetworzeniAutorzy.add(zapisanyAutor);
        }
        return przetworzeniAutorzy;
    }
    private void zmniejszIlosc(Ksiazka ksiazka) {
        ksiazka.setIlosc(ksiazka.getIlosc() - 1);
        ksiazkaRepository.save(ksiazka);
    }
    private void zwiekszIlosc(Ksiazka ksiazka) {
        ksiazka.setIlosc(ksiazka.getIlosc() + 1);
        ksiazkaRepository.save(ksiazka);
    }

    private void utworzKsiazke(DaneKsiazki daneKsiazki, Set<Autor> autorzy) {
        Ksiazka ksiazka = new Ksiazka();
        ksiazka.setDaneKsiazki(daneKsiazki);
        ksiazka.setStatus(Status.WYDANA);
        ksiazka.setIlosc(1);
        ksiazkaRepository.save(ksiazka);
        dodajKsiazkeDoAutorow(autorzy, ksiazka);
    }

    private void dodajKsiazkeDoAutorow(Set<Autor> autorzy, Ksiazka ksiazka) {
        for (Autor autor : autorzy) {
            autor.getKsiazki().add(ksiazka);
            autorRepository.save(autor);
        }
    }
}

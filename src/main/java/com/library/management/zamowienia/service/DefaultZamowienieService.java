package com.library.management.zamowienia.service;


import com.library.management.ksiazka.entities.DaneKsiazki;
import com.library.management.ksiazka.repositories.DaneKsiazkiRepository;
import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.zamowienia.controller.ZamowienieRequest;
import com.library.management.zamowienia.entities.Zamowienie;
import com.library.management.zamowienia.entities.ZamowioneKsiazki;
import com.library.management.zamowienia.repository.ZamowienieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Default zamowienie service.
 */
@Service
public class DefaultZamowienieService  implements ZamowienieService {

    @Autowired
    private ZamowienieRepository zamowienieRepository;

    @Autowired
    private DaneKsiazkiRepository daneKsiazkiRepository;

    public Zamowienie createZamowienie(ZamowienieRequest zamowienieRequest, Uzytkownik uzytkownik) {
        Zamowienie zamowienie = new Zamowienie();
        zamowienie.setDataZamowienia(LocalDate.now());
        zamowienie.setUzytkownik(uzytkownik);

        Set<ZamowioneKsiazki> zamowioneKsiazkiSet = new HashSet<>();

        for (ZamowienieRequest.KsiazkaZamowienie ksiazkaZamowienie : zamowienieRequest.getKsiazki()) {
            DaneKsiazki daneKsiazki = daneKsiazkiRepository.findById(ksiazkaZamowienie.getDaneKsiazkiId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

            ZamowioneKsiazki zamowioneKsiazki = new ZamowioneKsiazki();
            zamowioneKsiazki.setZamowienie(zamowienie);
            zamowioneKsiazki.setDaneKsiazki(daneKsiazki);
            zamowioneKsiazki.setIlosc(ksiazkaZamowienie.getIlosc());

            zamowioneKsiazkiSet.add(zamowioneKsiazki);
        }

        zamowienie.setZamowioneKsiazki(zamowioneKsiazkiSet);
        return zamowienieRepository.save(zamowienie);
    }

    @Override
    public List<Zamowienie> getAll() {
        return zamowienieRepository.findAll();
    }
}


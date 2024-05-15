package com.library.management.ksiazka.services.implementations;

import com.library.management.ksiazka.controller.dtos.KsiazkaRequestDTO;
import com.library.management.ksiazka.controller.dtos.KsiazkaResponseDTO;
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
import java.util.stream.Collectors;

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
    public KsiazkaResponseDTO dodajKsiazke(KsiazkaRequestDTO ksiazkaDTO) {
        Set<Autor> autorzy = ksiazkaDTO.getAutorIds().stream()
                .map(id -> autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor nie znaleziony: " + id)))
                .collect(Collectors.toSet());

        Wydawnictwo wydawnictwo = wydawnictwoRepository.findById(ksiazkaDTO.getWydawnictwoId())
                .orElseThrow( () -> new IllegalArgumentException("Wydawnictwo nie istnieje"));

        DaneKsiazki daneKsiazki = daneKsiazkiRepository
                .findByTytulAndRokWydaniaAndAutorzyIn(ksiazkaDTO.getTytul(), ksiazkaDTO.getRokWydania(), autorzy)
                .orElseGet(() -> stworzDaneKsiazki(ksiazkaDTO, autorzy, wydawnictwo));

        for (int i = 0; i < ksiazkaDTO.getIlosc(); i++) {
            Ksiazka ksiazka = new Ksiazka();
            ksiazka.setDaneKsiazki(daneKsiazki);
            ksiazka.setStatus(Status.DOSTEPNA);
            ksiazkaRepository.save(ksiazka);
        }
        return populujResponse(daneKsiazki, Status.DOSTEPNA);
    }

    @Override
    public List<Ksiazka> wyswietlKsiazki() {
        return ksiazkaRepository.findAll();
    }

    @Override
    public List<Ksiazka> wyswietlKsiazkiOdanymStatusie(String inputStatus) {
        Status status = Status.valueOf(inputStatus);
        return wyswietlKsiazki()
                .stream()
                .filter(ksiazka -> ksiazka.getStatus().equals(status))
                .toList();
    }

    @Override
    public KsiazkaResponseDTO wydajKsiazke(int ksiazkaId) {
        Ksiazka doWydania = ksiazkaRepository.findById(ksiazkaId)
                .orElseThrow(() -> new IllegalArgumentException("Ksiazka nie znaleziona"));
        doWydania.setStatus(Status.WYDANA);
        ksiazkaRepository.save(doWydania);
        return populujResponse(doWydania.getDaneKsiazki(), Status.WYDANA);
    }

    @Override
    public KsiazkaResponseDTO odbierzKsiazke(int ksiazkaId) {
        Ksiazka doOdebrania = ksiazkaRepository.findById(ksiazkaId)
                .orElseThrow(() -> new IllegalArgumentException("Ksiazka nie znaleziona"));
        doOdebrania.setStatus(Status.DOSTEPNA);
        ksiazkaRepository.save(doOdebrania);
        return populujResponse(doOdebrania.getDaneKsiazki(), Status.DOSTEPNA);
    }

    private DaneKsiazki stworzDaneKsiazki(KsiazkaRequestDTO ksiazkaDTO, Set<Autor> autorzy, Wydawnictwo wydawnictwo) {
        DaneKsiazki noweDane = new DaneKsiazki();
        noweDane.setTytul(ksiazkaDTO.getTytul());
        noweDane.setAutorzy(autorzy);
        noweDane.setWydawnictwo(wydawnictwo);
        noweDane.setRokWydania(ksiazkaDTO.getRokWydania());
        return daneKsiazkiRepository.save(noweDane);
    }

    private KsiazkaResponseDTO populujResponse(DaneKsiazki daneKsiazki, Status status) {
        KsiazkaResponseDTO responseDTO = new KsiazkaResponseDTO();
        responseDTO.setTytul(daneKsiazki.getTytul());
        responseDTO.setAutorzy(daneKsiazki.getAutorzy());
        responseDTO.setWydawnictwo(daneKsiazki.getWydawnictwo());
        responseDTO.setStatus(status);
        responseDTO.setIlosc(ksiazkaRepository.countByDaneKsiazkiAndStatus(daneKsiazki, status));
        return responseDTO;
    }
}

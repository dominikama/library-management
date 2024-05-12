package com.library.management.ksiazka.services.implementations;

import com.library.management.ksiazka.entities.Wydawnictwo;
import com.library.management.ksiazka.repositories.WydawnictwoRepository;
import com.library.management.ksiazka.services.WydawnictwoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DefaultWydawnictwoService implements WydawnictwoService {

    WydawnictwoRepository wydawnictwoRepository;

    public DefaultWydawnictwoService(WydawnictwoRepository wydawnictwoRepository) {
        this.wydawnictwoRepository = wydawnictwoRepository;
    }

    @Override
    public Wydawnictwo dodajWydawnictwo(Wydawnictwo wydawnictwo) {
        return wydawnictwoRepository.save(wydawnictwo);
    }

    @Override
    public List<Wydawnictwo> wszystkieWydawnictwa() {
        return wydawnictwoRepository.findAll();
    }
}

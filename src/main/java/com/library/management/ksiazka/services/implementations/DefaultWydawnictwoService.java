package com.library.management.ksiazka.services.implementations;

import com.library.management.ksiazka.entities.Wydawnictwo;
import com.library.management.ksiazka.repositories.WydawnictwoRepository;
import com.library.management.ksiazka.services.WydawnictwoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Default wydawnictwo service.
 */
@Service
public class DefaultWydawnictwoService implements WydawnictwoService {

    /**
     * The Wydawnictwo repository.
     */
    WydawnictwoRepository wydawnictwoRepository;

    /**
     * Instantiates a new Default wydawnictwo service.
     *
     * @param wydawnictwoRepository the wydawnictwo repository
     */
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

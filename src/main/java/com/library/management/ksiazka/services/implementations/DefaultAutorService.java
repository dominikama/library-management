package com.library.management.ksiazka.services.implementations;

import com.library.management.ksiazka.entities.Autor;
import com.library.management.ksiazka.repositories.AutorRepository;
import com.library.management.ksiazka.services.AutorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Default autor service.
 */
@Service
public class DefaultAutorService implements AutorService {

    private AutorRepository autorRepository;

    /**
     * Instantiates a new Default autor service.
     *
     * @param autorRepository the autor repository
     */
    public DefaultAutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public Autor dodajAutora(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public List<Autor> wszyscyAutorzy() {
        return autorRepository.findAll();
    }
}

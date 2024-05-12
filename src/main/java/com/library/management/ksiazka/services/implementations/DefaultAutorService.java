package com.library.management.ksiazka.services.implementations;

import com.library.management.ksiazka.entities.Autor;
import com.library.management.ksiazka.repositories.AutorRepository;
import com.library.management.ksiazka.services.AutorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAutorService implements AutorService {

    private AutorRepository autorRepository;

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

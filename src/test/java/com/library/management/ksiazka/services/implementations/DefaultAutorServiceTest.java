package com.library.management.ksiazka.services.implementations;

import com.library.management.ksiazka.entities.Autor;
import com.library.management.ksiazka.repositories.AutorRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DefaultAutorServiceTest {
    @Test
    void dodajAutor() {
        AutorRepository autorRepository = mock(AutorRepository.class);
        DefaultAutorService defaultAutorService = new DefaultAutorService(autorRepository);
        defaultAutorService.dodajAutora(mockAutora("Anna", "Kowalska"));
        verify(autorRepository, times(1)).save(any(Autor.class));
    }

    @Test
    void wyswietlAutorzy() {
        List<Autor> autorzy = List.of(mockAutora("Anna", "Kowalska"), mockAutora("Jan", "Kowalski"));
        AutorRepository autorRepository = mock(AutorRepository.class);
        DefaultAutorService defaultAutorService = new DefaultAutorService(autorRepository);
        when(autorRepository.findAll()).thenReturn(autorzy);
        assertEquals(2, defaultAutorService.wszyscyAutorzy().size());
    }

    private Autor mockAutora(String imie, String nazwisko) {
        Autor autor = new Autor();
        autor.setImie(imie);
        autor.setNazwisko(nazwisko);
        return autor;
    }
}
package com.library.management.ksiazka.services;

import com.library.management.ksiazka.entities.Autor;

import java.util.List;

public interface AutorService {
    Autor dodajAutora(Autor autor);

    List<Autor> wszyscyAutorzy();
}

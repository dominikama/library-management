package com.library.management.ksiazka.services;

import com.library.management.ksiazka.entities.Autor;

import java.util.List;

/**
 * The interface Autor service.
 */
public interface AutorService {
    /**
     * Dodaj autora autor.
     *
     * @param autor the autor
     * @return the autor
     */
    Autor dodajAutora(Autor autor);

    /**
     * Wszyscy autorzy list.
     *
     * @return the list
     */
    List<Autor> wszyscyAutorzy();
}

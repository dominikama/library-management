package com.library.management.zamowienia.service;

import com.library.management.uzytkownik.Uzytkownik;
import com.library.management.zamowienia.controller.ZamowienieRequest;
import com.library.management.zamowienia.entities.Zamowienie;

import java.util.List;

/**
 * The interface Zamowienie service.
 */
public interface ZamowienieService {
    /**
     * Create zamowienie zamowienie.
     *
     * @param zamowienieRequest the zamowienie request
     * @param uzytkownik        the uzytkownik
     * @return the zamowienie
     */
    Zamowienie createZamowienie(ZamowienieRequest zamowienieRequest, Uzytkownik uzytkownik);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<Zamowienie> getAll();
}

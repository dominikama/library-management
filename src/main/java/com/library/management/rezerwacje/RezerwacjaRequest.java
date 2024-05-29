package com.library.management.rezerwacje;

import com.library.management.rezerwacje.stretegies.Typ;

import java.util.List;

/**
 * The type Rezerwacja request.
 */
public class RezerwacjaRequest {

    private List<Integer> listaKsiazek;

    private int uzytkownik;

    private Typ typ;

    /**
     * Gets lista ksiazek.
     *
     * @return the lista ksiazek
     */
    public List<Integer> getListaKsiazek() {
        return listaKsiazek;
    }

    /**
     * Sets lista ksiazek.
     *
     * @param listaKsiazek the lista ksiazek
     */
    public void setListaKsiazek(List<Integer> listaKsiazek) {
        this.listaKsiazek = listaKsiazek;
    }

    /**
     * Gets uzytkownik.
     *
     * @return the uzytkownik
     */
    public int getUzytkownik() {
        return uzytkownik;
    }

    /**
     * Sets uzytkownik.
     *
     * @param uzytkownik the uzytkownik
     */
    public void setUzytkownik(int uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    /**
     * Gets typ.
     *
     * @return the typ
     */
    public Typ getTyp() {
        return typ;
    }

    /**
     * Sets typ.
     *
     * @param typ the typ
     */
    public void setTyp(Typ typ) {
        this.typ = typ;
    }
}

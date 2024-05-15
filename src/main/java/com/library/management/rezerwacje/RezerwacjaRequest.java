package com.library.management.rezerwacje;

import com.library.management.rezerwacje.stretegies.Typ;

import java.util.List;

public class RezerwacjaRequest {

    private List<Integer> listaKsiazek;

    private int uzytkownik;

    private Typ typ;

    public List<Integer> getListaKsiazek() {
        return listaKsiazek;
    }

    public void setListaKsiazek(List<Integer> listaKsiazek) {
        this.listaKsiazek = listaKsiazek;
    }

    public int getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(int uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }
}

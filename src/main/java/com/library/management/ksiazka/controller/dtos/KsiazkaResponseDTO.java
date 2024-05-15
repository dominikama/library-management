package com.library.management.ksiazka.controller.dtos;

import com.library.management.ksiazka.entities.Autor;
import com.library.management.ksiazka.entities.Status;
import com.library.management.ksiazka.entities.Wydawnictwo;

import java.util.List;
import java.util.Set;

public class KsiazkaResponseDTO {

    private Status status;
    private String tytul;
    private Wydawnictwo wydawnictwo;
    private Set<Autor> autorzy;
    private int ilosc;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Wydawnictwo getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(Wydawnictwo wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    public Set<Autor> getAutorzy() {
        return autorzy;
    }

    public void setAutorzy(Set<Autor> autorzy) {
        this.autorzy = autorzy;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}

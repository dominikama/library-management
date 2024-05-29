package com.library.management.ksiazka.controller.dtos;

import com.library.management.ksiazka.entities.Autor;
import com.library.management.ksiazka.entities.Status;
import com.library.management.ksiazka.entities.Wydawnictwo;

import java.util.Set;

/**
 * The type Ksiazka response dto.
 */
public class KsiazkaResponseDTO {

    private Status status;
    private String tytul;
    private Wydawnictwo wydawnictwo;
    private Set<Autor> autorzy;
    private int ilosc;


    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets tytul.
     *
     * @return the tytul
     */
    public String getTytul() {
        return tytul;
    }

    /**
     * Sets tytul.
     *
     * @param tytul the tytul
     */
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    /**
     * Gets wydawnictwo.
     *
     * @return the wydawnictwo
     */
    public Wydawnictwo getWydawnictwo() {
        return wydawnictwo;
    }

    /**
     * Sets wydawnictwo.
     *
     * @param wydawnictwo the wydawnictwo
     */
    public void setWydawnictwo(Wydawnictwo wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    /**
     * Gets autorzy.
     *
     * @return the autorzy
     */
    public Set<Autor> getAutorzy() {
        return autorzy;
    }

    /**
     * Sets autorzy.
     *
     * @param autorzy the autorzy
     */
    public void setAutorzy(Set<Autor> autorzy) {
        this.autorzy = autorzy;
    }

    /**
     * Gets ilosc.
     *
     * @return the ilosc
     */
    public int getIlosc() {
        return ilosc;
    }

    /**
     * Sets ilosc.
     *
     * @param ilosc the ilosc
     */
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}

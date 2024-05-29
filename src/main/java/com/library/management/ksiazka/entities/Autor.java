package com.library.management.ksiazka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Autor.
 */
@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autorId;

    private String imie;

    private String nazwisko;

    @ManyToMany(mappedBy = "autorzy", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<DaneKsiazki> daneKsiazki = new HashSet<>();

    /**
     * Gets autor id.
     *
     * @return the autor id
     */
    public int getAutorId() {
        return autorId;
    }

    /**
     * Sets autor id.
     *
     * @param autorId the autor id
     */
    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    /**
     * Gets imie.
     *
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * Sets imie.
     *
     * @param imie the imie
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * Gets nazwisko.
     *
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Sets nazwisko.
     *
     * @param nazwisko the nazwisko
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * Gets dane ksiazki.
     *
     * @return the dane ksiazki
     */
    public Set<DaneKsiazki> getDaneKsiazki() {
        return daneKsiazki;
    }

    /**
     * Sets dane ksiazki.
     *
     * @param daneKsiazki the dane ksiazki
     */
    public void setDaneKsiazki(Set<DaneKsiazki> daneKsiazki) {
        this.daneKsiazki = daneKsiazki;
    }
}

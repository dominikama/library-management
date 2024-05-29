package com.library.management.ksiazka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.management.zamowienia.entities.ZamowioneKsiazki;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Dane ksiazki.
 */
@Entity
@Table(name = "dane_ksiazki")
public class DaneKsiazki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int daneKsiazkiId;

    private String tytul;

    private int rokWydania;

    @ManyToOne
    @JoinColumn(name = "wydawnictwo_id")
    private Wydawnictwo wydawnictwo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "autorzy_ksiazki",
            joinColumns = @JoinColumn(name = "dane_ksiazki_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autorzy;

    @OneToMany(mappedBy = "daneKsiazki", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<ZamowioneKsiazki> zamowioneKsiazki = new HashSet<>();

    /**
     * Gets zamowione ksiazki.
     *
     * @return the zamowione ksiazki
     */
    public Set<ZamowioneKsiazki> getZamowioneKsiazki() {
        return zamowioneKsiazki;
    }

    /**
     * Sets zamowione ksiazki.
     *
     * @param zamowioneKsiazki the zamowione ksiazki
     */
    public void setZamowioneKsiazki(Set<ZamowioneKsiazki> zamowioneKsiazki) {
        this.zamowioneKsiazki = zamowioneKsiazki;
    }

    /**
     * Gets dane ksiazki id.
     *
     * @return the dane ksiazki id
     */
    public int getDaneKsiazkiId() {
        return daneKsiazkiId;
    }

    /**
     * Sets dane ksiazki id.
     *
     * @param daneKsiazkiId the dane ksiazki id
     */
    public void setDaneKsiazkiId(int daneKsiazkiId) {
        this.daneKsiazkiId = daneKsiazkiId;
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
     * Gets rok wydania.
     *
     * @return the rok wydania
     */
    public int getRokWydania() {
        return rokWydania;
    }

    /**
     * Sets rok wydania.
     *
     * @param rokWydania the rok wydania
     */
    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
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
}


package com.library.management.ksiazka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.management.rezerwacje.Rezerwacja;
import jakarta.persistence.*;

import java.util.Set;

/**
 * The type Ksiazka.
 */
@Entity
@Table(name = "ksiazki")
public class Ksiazka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ksiazkaId;

    @ManyToOne
    @JoinColumn(name = "dane_ksiazki_id")
    private DaneKsiazki daneKsiazki;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany(mappedBy = "ksiazki")
    @JsonIgnore
    private Set<Rezerwacja> rezerwacje;

    /**
     * Gets ksiazka id.
     *
     * @return the ksiazka id
     */
    public int getKsiazkaId() {
        return ksiazkaId;
    }

    /**
     * Sets ksiazka id.
     *
     * @param ksiazkaId the ksiazka id
     */
    public void setKsiazkaId(int ksiazkaId) {
        this.ksiazkaId = ksiazkaId;
    }

    /**
     * Gets dane ksiazki.
     *
     * @return the dane ksiazki
     */
    public DaneKsiazki getDaneKsiazki() {
        return daneKsiazki;
    }

    /**
     * Sets dane ksiazki.
     *
     * @param daneKsiazki the dane ksiazki
     */
    public void setDaneKsiazki(DaneKsiazki daneKsiazki) {
        this.daneKsiazki = daneKsiazki;
    }

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
     * Gets rezerwacje.
     *
     * @return the rezerwacje
     */
    public Set<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    /**
     * Sets rezerwacje.
     *
     * @param rezerwacje the rezerwacje
     */
    public void setRezerwacje(Set<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }
}


package com.library.management.ksiazka.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.library.management.rezerwacje.Rezerwacja;
import jakarta.persistence.*;

import java.util.Set;

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

    private int ilosc;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "autorzy_ksiazki",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    @JsonManagedReference
    private Set<Autor> autorzy;

    @ManyToMany(mappedBy = "ksiazki")
    private Set<Rezerwacja> rezerwacje;

    public int getKsiazkaId() {
        return ksiazkaId;
    }

    public void setKsiazkaId(int ksiazkaId) {
        this.ksiazkaId = ksiazkaId;
    }

    public DaneKsiazki getDaneKsiazki() {
        return daneKsiazki;
    }

    public void setDaneKsiazki(DaneKsiazki daneKsiazki) {
        this.daneKsiazki = daneKsiazki;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public Set<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(Set<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }
}


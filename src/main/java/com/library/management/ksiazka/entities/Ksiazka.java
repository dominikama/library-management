package com.library.management.ksiazka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(mappedBy = "ksiazki")
    @JsonIgnore
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

    public Set<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(Set<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }
}


package com.library.management.ksiazka.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

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

    public int getDaneKsiazkiId() {
        return daneKsiazkiId;
    }

    public void setDaneKsiazkiId(int daneKsiazkiId) {
        this.daneKsiazkiId = daneKsiazkiId;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
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
}


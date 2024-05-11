package com.library.management.ksiazka.entities;

import jakarta.persistence.*;

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
}


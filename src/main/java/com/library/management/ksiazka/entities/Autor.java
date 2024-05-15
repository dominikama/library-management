package com.library.management.ksiazka.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Set<DaneKsiazki> getDaneKsiazki() {
        return daneKsiazki;
    }

    public void setDaneKsiazki(Set<DaneKsiazki> daneKsiazki) {
        this.daneKsiazki = daneKsiazki;
    }
}

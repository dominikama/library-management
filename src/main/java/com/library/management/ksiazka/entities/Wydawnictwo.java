package com.library.management.ksiazka.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "wydawnictwo")
public class Wydawnictwo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wydawnictwoId;

    private String wydawnictwoNazwa;

    public int getWydawnictwoId() {
        return wydawnictwoId;
    }

    public void setWydawnictwoId(int wydawnictwoId) {
        this.wydawnictwoId = wydawnictwoId;
    }

    public String getWydawnictwoNazwa() {
        return wydawnictwoNazwa;
    }

    public void setWydawnictwoNazwa(String wydawnictwoNazwa) {
        this.wydawnictwoNazwa = wydawnictwoNazwa;
    }
}

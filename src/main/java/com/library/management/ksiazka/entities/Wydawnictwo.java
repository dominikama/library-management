package com.library.management.ksiazka.entities;

import jakarta.persistence.*;

/**
 * The type Wydawnictwo.
 */
@Entity
@Table(name = "wydawnictwo")
public class Wydawnictwo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wydawnictwoId;

    private String wydawnictwoNazwa;

    /**
     * Gets wydawnictwo id.
     *
     * @return the wydawnictwo id
     */
    public int getWydawnictwoId() {
        return wydawnictwoId;
    }

    /**
     * Sets wydawnictwo id.
     *
     * @param wydawnictwoId the wydawnictwo id
     */
    public void setWydawnictwoId(int wydawnictwoId) {
        this.wydawnictwoId = wydawnictwoId;
    }

    /**
     * Gets wydawnictwo nazwa.
     *
     * @return the wydawnictwo nazwa
     */
    public String getWydawnictwoNazwa() {
        return wydawnictwoNazwa;
    }

    /**
     * Sets wydawnictwo nazwa.
     *
     * @param wydawnictwoNazwa the wydawnictwo nazwa
     */
    public void setWydawnictwoNazwa(String wydawnictwoNazwa) {
        this.wydawnictwoNazwa = wydawnictwoNazwa;
    }
}

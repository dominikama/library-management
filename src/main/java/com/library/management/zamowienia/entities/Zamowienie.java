package com.library.management.zamowienia.entities;

import com.library.management.uzytkownik.Uzytkownik;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Zamowienie.
 */
@Entity
@Table(name = "zamowienia")
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zamowienieId;

    @Column(name = "data_zamowienia", nullable = false)
    private LocalDate dataZamowienia;

    @ManyToOne
    @JoinColumn(name = "uzytkownik_id", nullable = false)
    private Uzytkownik uzytkownik;

    @OneToMany(mappedBy = "zamowienie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ZamowioneKsiazki> zamowioneKsiazki = new HashSet<>();

    /**
     * Gets zamowienie id.
     *
     * @return the zamowienie id
     */
    public int getZamowienieId() {
        return zamowienieId;
    }

    /**
     * Sets zamowienie id.
     *
     * @param zamowienieId the zamowienie id
     */
    public void setZamowienieId(int zamowienieId) {
        this.zamowienieId = zamowienieId;
    }

    /**
     * Gets data zamowienia.
     *
     * @return the data zamowienia
     */
    public LocalDate getDataZamowienia() {
        return dataZamowienia;
    }

    /**
     * Sets data zamowienia.
     *
     * @param dataZamowienia the data zamowienia
     */
    public void setDataZamowienia(LocalDate dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    /**
     * Gets uzytkownik.
     *
     * @return the uzytkownik
     */
    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    /**
     * Sets uzytkownik.
     *
     * @param uzytkownik the uzytkownik
     */
    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

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
}

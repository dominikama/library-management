package com.library.management.rezerwacje;

import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.uzytkownik.Uzytkownik;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * The type Rezerwacja.
 */
@Entity
@Table(name = "rezerwacje")
public class Rezerwacja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rezerwacjaId;

    private LocalDateTime startRezerwacja;

    private LocalDateTime  koniecRezerwacja;

    @ManyToMany
    @JoinTable(
            name = "rezerwacja_ksiazka",
            joinColumns = @JoinColumn(name = "rezerwacja_id"),
            inverseJoinColumns = @JoinColumn(name = "ksiazka_id")
    )
    private Set<Ksiazka> ksiazki;

    @ManyToOne
    @JoinColumn(name = "uzytkownik_id", nullable = false)
    private Uzytkownik uzytkownik;

    /**
     * Gets rezerwacja id.
     *
     * @return the rezerwacja id
     */
    public int getRezerwacjaId() {
        return rezerwacjaId;
    }

    /**
     * Sets rezerwacja id.
     *
     * @param rezerwacjaId the rezerwacja id
     */
    public void setRezerwacjaId(int rezerwacjaId) {
        this.rezerwacjaId = rezerwacjaId;
    }

    /**
     * Gets start rezerwacja.
     *
     * @return the start rezerwacja
     */
    public LocalDateTime getStartRezerwacja() {
        return startRezerwacja;
    }

    /**
     * Sets start rezerwacja.
     *
     * @param startRezerwacja the start rezerwacja
     */
    public void setStartRezerwacja(LocalDateTime startRezerwacja) {
        this.startRezerwacja = startRezerwacja;
    }

    /**
     * Gets koniec rezerwacja.
     *
     * @return the koniec rezerwacja
     */
    public LocalDateTime getKoniecRezerwacja() {
        return koniecRezerwacja;
    }

    /**
     * Sets koniec rezerwacja.
     *
     * @param koniecRezerwacja the koniec rezerwacja
     */
    public void setKoniecRezerwacja(LocalDateTime koniecRezerwacja) {
        this.koniecRezerwacja = koniecRezerwacja;
    }

    /**
     * Gets ksiazki.
     *
     * @return the ksiazki
     */
    public Set<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    /**
     * Sets ksiazki.
     *
     * @param ksiazki the ksiazki
     */
    public void setKsiazki(Set<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
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
}


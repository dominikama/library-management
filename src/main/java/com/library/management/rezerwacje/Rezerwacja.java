package com.library.management.rezerwacje;

import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.uzytkownik.Uzytkownik;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

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

    public int getRezerwacjaId() {
        return rezerwacjaId;
    }

    public void setRezerwacjaId(int rezerwacjaId) {
        this.rezerwacjaId = rezerwacjaId;
    }

    public LocalDateTime getStartRezerwacja() {
        return startRezerwacja;
    }

    public void setStartRezerwacja(LocalDateTime startRezerwacja) {
        this.startRezerwacja = startRezerwacja;
    }

    public LocalDateTime getKoniecRezerwacja() {
        return koniecRezerwacja;
    }

    public void setKoniecRezerwacja(LocalDateTime koniecRezerwacja) {
        this.koniecRezerwacja = koniecRezerwacja;
    }

    public Set<Ksiazka> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(Set<Ksiazka> ksiazki) {
        this.ksiazki = ksiazki;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }
}


package com.library.management.rezerwacje;

import com.library.management.ksiazka.entities.Ksiazka;
import com.library.management.uzytkownik.Uzytkownik;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "rezerwacje")
public class Rezerwacja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rezerwacjaId;

    @Temporal(TemporalType.DATE)
    private Date startRezerwacja;

    @Temporal(TemporalType.DATE)
    private Date koniecRezerwacja;

    private boolean priorytet;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "rezerwacja_ksiazka",
            joinColumns = @JoinColumn(name = "rezerwacja_id"),
            inverseJoinColumns = @JoinColumn(name = "ksiazka_id")
    )
    private Set<Ksiazka> ksiazki;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uzytkownik_id", nullable = false)
    private Uzytkownik uzytkownik;

    public int getRezerwacjaId() {
        return rezerwacjaId;
    }

    public void setRezerwacjaId(int rezerwacjaId) {
        this.rezerwacjaId = rezerwacjaId;
    }

    public Date getStartRezerwacja() {
        return startRezerwacja;
    }

    public void setStartRezerwacja(Date startRezerwacja) {
        this.startRezerwacja = startRezerwacja;
    }

    public Date getKoniecRezerwacja() {
        return koniecRezerwacja;
    }

    public void setKoniecRezerwacja(Date koniecRezerwacja) {
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


package com.library.management.uzytkownik;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.management.rezerwacje.Rezerwacja;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "uzytkownicy")
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uzytkownikId;

    @Column(nullable = false, length = 100)
    private String imie;

    @Column(nullable = false, length = 100)
    private String nazwisko;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "uzytkownik")
    @JsonIgnore
    private List<Rezerwacja> rezerwacje;

    public int getUzytkownikId() {
        return uzytkownikId;
    }

    public void setUzytkownikId(int uzytkownikId) {
        this.uzytkownikId = uzytkownikId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    public void setRezerwacje(List<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }
}

package com.library.management.uzytkownik;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.management.rezerwacje.Rezerwacja;
import com.library.management.zamowienia.entities.Zamowienie;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Uzytkownik.
 */
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

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "uzytkownik")
    @JsonIgnore
    private List<Rezerwacja> rezerwacje;

    @OneToMany(mappedBy = "uzytkownik", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Zamowienie> zamowienia = new HashSet<>();

    /**
     * Gets zamowienia.
     *
     * @return the zamowienia
     */
    public Set<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    /**
     * Sets zamowienia.
     *
     * @param zamowienia the zamowienia
     */
    public void setZamowienia(Set<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets uzytkownik id.
     *
     * @return the uzytkownik id
     */
    public int getUzytkownikId() {
        return uzytkownikId;
    }

    /**
     * Sets uzytkownik id.
     *
     * @param uzytkownikId the uzytkownik id
     */
    public void setUzytkownikId(int uzytkownikId) {
        this.uzytkownikId = uzytkownikId;
    }

    /**
     * Gets imie.
     *
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * Sets imie.
     *
     * @param imie the imie
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * Gets nazwisko.
     *
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Sets nazwisko.
     *
     * @param nazwisko the nazwisko
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets rezerwacje.
     *
     * @return the rezerwacje
     */
    public List<Rezerwacja> getRezerwacje() {
        return rezerwacje;
    }

    /**
     * Sets rezerwacje.
     *
     * @param rezerwacje the rezerwacje
     */
    public void setRezerwacje(List<Rezerwacja> rezerwacje) {
        this.rezerwacje = rezerwacje;
    }
}

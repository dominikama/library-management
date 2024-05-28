package com.library.management.zamowienia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.management.ksiazka.entities.DaneKsiazki;
import jakarta.persistence.*;

/**
 * The type Zamowione ksiazki.
 */
@Entity
@Table(name = "zamowione_ksiazki")
public class ZamowioneKsiazki {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "zamowienie_id")
    @JsonIgnore
    private Zamowienie zamowienie;

    @ManyToOne
    @JoinColumn(name = "dane_ksiazki_id")
    private DaneKsiazki daneKsiazki;

    @Column(nullable = false)
    private int ilosc;

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets zamowienie.
     *
     * @return the zamowienie
     */
    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    /**
     * Sets zamowienie.
     *
     * @param zamowienie the zamowienie
     */
    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    /**
     * Gets dane ksiazki.
     *
     * @return the dane ksiazki
     */
    public DaneKsiazki getDaneKsiazki() {
        return daneKsiazki;
    }

    /**
     * Sets dane ksiazki.
     *
     * @param daneKsiazki the dane ksiazki
     */
    public void setDaneKsiazki(DaneKsiazki daneKsiazki) {
        this.daneKsiazki = daneKsiazki;
    }

    /**
     * Gets ilosc.
     *
     * @return the ilosc
     */
    public int getIlosc() {
        return ilosc;
    }

    /**
     * Sets ilosc.
     *
     * @param ilosc the ilosc
     */
    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}

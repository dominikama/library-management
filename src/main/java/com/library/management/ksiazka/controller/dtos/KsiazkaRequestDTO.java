package com.library.management.ksiazka.controller.dtos;

import java.util.List;

/**
 * The type Ksiazka request dto.
 */
public class KsiazkaRequestDTO {
    private String tytul;
    private List<Integer> autorIds;
    private Integer wydawnictwoId;
    private Integer rokWydania;
    private Integer ilosc;
    private String status;

    /**
     * Gets tytul.
     *
     * @return the tytul
     */
// Gettery i settery
    public String getTytul() {
        return tytul;
    }

    /**
     * Sets tytul.
     *
     * @param tytul the tytul
     */
    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    /**
     * Gets autor ids.
     *
     * @return the autor ids
     */
    public List<Integer> getAutorIds() {
        return autorIds;
    }

    /**
     * Sets autor ids.
     *
     * @param autorIds the autor ids
     */
    public void setAutorIds(List<Integer> autorIds) {
        this.autorIds = autorIds;
    }

    /**
     * Gets wydawnictwo id.
     *
     * @return the wydawnictwo id
     */
    public Integer getWydawnictwoId() {
        return wydawnictwoId;
    }

    /**
     * Sets wydawnictwo id.
     *
     * @param wydawnictwoId the wydawnictwo id
     */
    public void setWydawnictwoId(Integer wydawnictwoId) {
        this.wydawnictwoId = wydawnictwoId;
    }

    /**
     * Gets rok wydania.
     *
     * @return the rok wydania
     */
    public Integer getRokWydania() {
        return rokWydania;
    }

    /**
     * Sets rok wydania.
     *
     * @param rokWydania the rok wydania
     */
    public void setRokWydania(Integer rokWydania) {
        this.rokWydania = rokWydania;
    }

    /**
     * Gets ilosc.
     *
     * @return the ilosc
     */
    public Integer getIlosc() {
        return ilosc;
    }

    /**
     * Sets ilosc.
     *
     * @param ilosc the ilosc
     */
    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}


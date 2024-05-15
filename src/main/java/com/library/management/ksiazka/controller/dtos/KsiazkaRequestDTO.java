package com.library.management.ksiazka.controller.dtos;

import java.util.List;

public class KsiazkaRequestDTO {
    private String tytul;
    private List<Integer> autorIds;
    private Integer wydawnictwoId;
    private Integer rokWydania;
    private Integer ilosc;
    private String status;

    // Gettery i settery
    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public List<Integer> getAutorIds() {
        return autorIds;
    }

    public void setAutorIds(List<Integer> autorIds) {
        this.autorIds = autorIds;
    }

    public Integer getWydawnictwoId() {
        return wydawnictwoId;
    }

    public void setWydawnictwoId(Integer wydawnictwoId) {
        this.wydawnictwoId = wydawnictwoId;
    }

    public Integer getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(Integer rokWydania) {
        this.rokWydania = rokWydania;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


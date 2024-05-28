package com.library.management.zamowienia.controller;


import java.util.List;

/**
 * The type Zamowienie request.
 */
public class ZamowienieRequest {

    private List<KsiazkaZamowienie> ksiazki;

    /**
     * Gets ksiazki.
     *
     * @return the ksiazki
     */
    public List<KsiazkaZamowienie> getKsiazki() {
        return ksiazki;
    }

    /**
     * Sets ksiazki.
     *
     * @param ksiazki the ksiazki
     */
    public void setKsiazki(List<KsiazkaZamowienie> ksiazki) {
        this.ksiazki = ksiazki;
    }

    /**
     * The type Ksiazka zamowienie.
     */
    public static class KsiazkaZamowienie {
        private int daneKsiazkiId;
        private int ilosc;

        /**
         * Gets dane ksiazki id.
         *
         * @return the dane ksiazki id
         */
        public int getDaneKsiazkiId() {
            return daneKsiazkiId;
        }

        /**
         * Sets dane ksiazki id.
         *
         * @param daneKsiazkiId the dane ksiazki id
         */
        public void setDaneKsiazkiId(int daneKsiazkiId) {
            this.daneKsiazkiId = daneKsiazkiId;
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
}

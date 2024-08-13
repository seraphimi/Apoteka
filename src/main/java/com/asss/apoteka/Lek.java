package com.asss.apoteka;

import java.io.Serializable;

public abstract class Lek implements Serializable, Comparable<Lek> {

    private int kolicina = 1;

    public void setAktivneKomponente(String aktivneKomponente) {
        this.aktivneKomponente = aktivneKomponente;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    private String aktivneKomponente;


    private String naziv;
    private double cena;

    private TipLeka tipLeka;

    public Lek(String aktivneKomponente, String naziv, double cena, TipLeka tipLeka) {
        this.aktivneKomponente = aktivneKomponente;

        this.naziv = naziv;
        this.cena = cena;
        this.tipLeka = tipLeka;
    }

    public String getAktivneKomponente() {
        return aktivneKomponente;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }


    public Lek() {
    }


    public String getTipLeka() {
        return tipLeka.getTip();
    }

    public void setTipLeka(TipLeka tipLeka) {
        this.tipLeka = tipLeka;
    }

    @Override
    public boolean equals(Object lek) {
        if (this == lek) return true;
        if (!(lek instanceof Lek drugiLek)) return false;
        return this.getNaziv().equalsIgnoreCase(drugiLek.getNaziv());

    }

    @Override
    public int compareTo(Lek lek) {
        if (this.getCena() > lek.getCena()) {
            return 1;
        } else if (this.getCena() < lek.getCena()) {
            return -1;
        } else {
            return 0;
        }
    }

}

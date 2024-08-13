package com.asss.apoteka;

import java.io.Serializable;

public class NaturalLek extends Lek implements Comparable<Lek>, Serializable {

    private String biljneKomponente;


    public NaturalLek() {

    }

    public String getBiljneKomponente() {
        return biljneKomponente;
    }

    public void setBiljneKomponente(String biljneKomponente) {
        this.biljneKomponente = biljneKomponente;
    }

    public NaturalLek(String naziv, double cena, TipLeka tipLeka, String biljneKomponente) {
        super(biljneKomponente, naziv, cena, tipLeka);
        this.biljneKomponente = biljneKomponente;
    }
}

package com.asss.apoteka;

import java.io.Serializable;

public class ChemicalLek extends Lek implements Comparable<Lek>, Serializable {
    private String aktivneHemikalije;


    public ChemicalLek(String naziv, double cena, TipLeka tipLeka, String aktivneHemikalije) {
        super(aktivneHemikalije, naziv, cena, tipLeka);
        this.aktivneHemikalije = aktivneHemikalije;
    }

    public ChemicalLek() {

    }


}

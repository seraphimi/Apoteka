package com.asss.apoteka;

public enum TipLeka {
    ANALGETIK("Analgetik"),
    ANTIBIOTIK("Antibiotik"),
    ANESTETIK("Anestetik");

    TipLeka(String tip) {
        this.tip = tip;
    }

    private final String tip;

    public String getTip() {
        return tip;
    }
}

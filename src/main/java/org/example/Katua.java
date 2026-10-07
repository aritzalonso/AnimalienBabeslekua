package org.example;

public class Katua extends Animalia {
    public Katua(String izena, int adina, double pisua) {
        super(izena, adina, pisua);
    }

    @Override
    public String eginSoinua() {
        return getIzena() + " Katua : Miau Miau!";
    }

    @Override
    public String getEspeziea() {
        return "Katua";
    }
}
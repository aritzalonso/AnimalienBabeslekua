package org.example;

public class Txakurra extends Animalia {
    public Txakurra(String izena, int adina, double pisua) {
        super(izena, adina, pisua);
    }

    @Override
    public String eginSoinua() {
        return getIzena() + " Txakurra: Guau Guau!";
    }

    @Override
    public String getEspeziea() {
        return "Txakurra";
    }
}
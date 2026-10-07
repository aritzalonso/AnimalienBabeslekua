package org.example;

public class Untxia extends Animalia {
    public Untxia(String izena, int adina, double pisua) {
        super(izena, adina, pisua);
    }

    @Override
    public String eginSoinua() {
        return getIzena() + " untxia: wfifw iwf!";
    }

    @Override
    public String getEspeziea() {
        return "Untxia";
    }
}
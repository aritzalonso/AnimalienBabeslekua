package org.example;

public class Untxia extends Animalia {

    public Untxia(String izena, int adina, double pisua) {
        super(izena, adina, pisua);
    }

    @Override
    public void eginSoinua() {
        System.out.println(getIzena() + " untxia: wfifw iwf!");
    }

    @Override
    public String getEspeziea() {
        return "Untxia";
    }
}
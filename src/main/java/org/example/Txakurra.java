package org.example;


public class Txakurra extends Animalia {

    public Txakurra(String izena, int adina, double pisua) {
        super(izena, adina, pisua);
    }

    @Override
    public void eginSoinua() {
        System.out.println(getIzena() + " Txakurra: Guau Guau!");
    }

    @Override
    public String getEspeziea() {
        return "Txakurra";
    }
}
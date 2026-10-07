package org.example;

public abstract class Animalia {
    private boolean adoptatua;
    private int adina;
    private double pisua;
    private String izena;

    public Animalia(String izena, int adina, double pisua) {
        this.izena = izena;
        this.adina = adina;
        this.pisua = pisua;
        this.adoptatua = false;
    }

    public boolean isAdoptatua() { return adoptatua; }
    public void setAdoptatua(boolean adoptatua) { this.adoptatua = adoptatua; }
    public int getAdina() { return adina; }
    public void setAdina(int adina) { this.adina = adina; }
    public double getPisua() { return pisua; }
    public void setPisua(double pisua) { this.pisua = pisua; }
    public String getIzena() { return izena; }
    public void setIzena(String izena) { this.izena = izena; }


    public abstract String eginSoinua();
    public abstract String getEspeziea();

    public void adoptatu() {
        this.adoptatua = true;
    }

    @Override
    public String toString() {
        String egoera = adoptatua ? "Adoptatua" : "Babeslekuan";
        return "[" + getEspeziea() + "] Izena: " + izena + " | Adina: " + adina +
                " | Pisua: " + pisua + "kg | Egoera: " + egoera;
    }
}
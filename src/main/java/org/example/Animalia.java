package org.example;


    public abstract class Animalia {
        public boolean isAdoptatua() {
            return adoptatua;
        }

        public void setAdoptatua(boolean adoptatua) {
            this.adoptatua = adoptatua;
        }

        private boolean adoptatua;

        public int getAdina() {
            return adina;
        }

        public void setAdina(int adina) {
            this.adina = adina;
        }

        private int adina;

        public double getPisua() {
            return pisua;
        }

        public void setPisua(double pisua) {
            this.pisua = pisua;
        }

        private double pisua;

        public String getIzena() {
            return izena;
        }

        public void setIzena(String izena) {
            this.izena = izena;
        }
        public abstract void eginSoinua();
        public abstract String getEspeziea();


        private String izena;

        public Animalia(String izena, int adina, double pisua) {
            this.izena = izena;
            this.adina = adina;
            this.pisua = pisua;
            this.adoptatua = false;
        }
    }
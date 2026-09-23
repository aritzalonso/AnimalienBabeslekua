package org.example;


    public abstract class Animalia {
        private boolean adoptatua;
        private int adina;
        private double pisua;
        public boolean isAdoptatua() {
            return adoptatua;
        }

        public void setAdoptatua(boolean adoptatua) {
            this.adoptatua = adoptatua;
        }


        public int getAdina() {
            return adina;
        }

        public void setAdina(int adina) {
            this.adina = adina;
        }



        public double getPisua() {
            return pisua;
        }

        public void setPisua(double pisua) {
            this.pisua = pisua;
        }


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

        public void adoptatu() {
        }
    }
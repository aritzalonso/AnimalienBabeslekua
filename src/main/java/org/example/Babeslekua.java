// Babeslekua.java
package org.example;

import org.example.dao.AnimaliaDAO;
import java.util.ArrayList;

public class Babeslekua {
    private AnimaliaDAO animaliaDAO;
    private StringBuilder erregistroa;

    public Babeslekua() {
        this.animaliaDAO = new AnimaliaDAO();
        this.erregistroa = new StringBuilder("Ongi etorri Animalien Babeslekura!\n====================================\n");
    }

    public void gehituErregistroa(String mezua) {
        erregistroa.append(mezua).append("\n");
    }

    public String getErregistroa() {
        return erregistroa.toString();
    }

    public void gehituAnimalia(Animalia animalia) {
        animaliaDAO.txertatu(animalia);
    }

    public Animalia bilatuAnimalia(String izena) {
        return animaliaDAO.bilatuIzenarekin(izena);
    }

    public boolean adoptatuAnimalia(String izena) {
        Animalia a = animaliaDAO.bilatuIzenarekin(izena);
        if (a != null && !a.isAdoptatua()) {
            return animaliaDAO.eguneratuAdopzioa(izena, true);
        }
        return false;
    }

    public boolean ezabatuAnimalia(String izena) {
        return animaliaDAO.ezabatu(izena);
    }

    public String erakutsiAnimaliak() {
        ArrayList<Animalia> animaliak = animaliaDAO.lortuGuztiak();
        if (animaliak.isEmpty()) {
            return "Ez dago animaliarik babeslekuan.";
        }
        StringBuilder sb = new StringBuilder();
        for (Animalia a : animaliak) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString().trim();
    }

    public String eginSoinuak() {
        ArrayList<Animalia> animaliak = animaliaDAO.lortuGuztiak();
        if (animaliak.isEmpty()) {
            return "Ez dago animaliarik babeslekuan.";
        }
        StringBuilder sb = new StringBuilder();
        for (Animalia a : animaliak) {
            sb.append(a.eginSoinua()).append("\n");
        }
        return sb.toString().trim();
    }
}
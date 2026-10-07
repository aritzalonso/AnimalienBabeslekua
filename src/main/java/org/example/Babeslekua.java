package org.example;
import java.util.ArrayList;

public class Babeslekua {
    private ArrayList<Animalia> animaliak;

    public Babeslekua() {
        animaliak = new ArrayList<>();
    }

    public String eginSoinuak() {
        if (animaliak.isEmpty()) {
            return "Ez dago animaliarik babeslekuan.";
        }
        StringBuilder sb = new StringBuilder();
        for (Animalia a : animaliak) {
            sb.append(a.eginSoinua()).append("\n");
        }
        return sb.toString();
    }

    public void gehituAnimalia(Animalia animalia) {
        animaliak.add(animalia);
    }

    public boolean adoptatuAnimalia(String izena) {
        Animalia a = bilatuAnimalia(izena);
        if (a != null && !a.isAdoptatua()) {
            a.adoptatu();
            return true;
        }
        return false;
    }

    public boolean ezabatuAnimalia(String izena) {
        Animalia a = bilatuAnimalia(izena);
        if (a != null) {
            animaliak.remove(a);
            return true;
        }
        return false;
    }

    public Animalia bilatuAnimalia(String izena) {
        for (Animalia a : animaliak) {
            if (a.getIzena().equalsIgnoreCase(izena)) {
                return a;
            }
        }
        return null;
    }


    public String erakutsiAnimaliak() {
        if (animaliak.isEmpty()) {
            return "Ez dago animaliarik babeslekuan.";
        }
        StringBuilder sb = new StringBuilder();
        for (Animalia a : animaliak) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }
}
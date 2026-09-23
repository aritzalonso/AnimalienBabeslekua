package org.example;
import java.util.ArrayList;

public class Babeslekua {
    private ArrayList<Animalia> animaliak;

    public Babeslekua() {
        animaliak = new ArrayList<>();
    }

    public void eginSoinuak() {
        if (animaliak.isEmpty()) {
            System.out.println("Ez dago animaliarik babeslekuan.");
            return;
        }
        for (Animalia a : animaliak) {
            a.eginSoinua();
        }
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

    public void erakutsiAnimaliak() {
        if (animaliak.isEmpty()) {
            System.out.println("Ez dago animaliarik babeslekuan.");
            return;
        }
        for (Animalia a : animaliak) {
            System.out.println(a);
        }
    }
}
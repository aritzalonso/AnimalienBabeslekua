// AdoptatuController.java
package org.example;

public class AdoptatuController {
    private Babeslekua model;
    private AdoptatuView view;
    private SceneManager sceneManager;

    public AdoptatuController(Babeslekua model, AdoptatuView view, SceneManager sceneManager) {
        this.model = model;
        this.view = view;
        this.sceneManager = sceneManager;
    }

    public void adoptatu() {
        String izena = view.getIzena().trim();
        if (izena.isEmpty()) {
            view.erakutsiErrorea("Sartu izen bat mesedez.");
            return;
        }

        if (model.adoptatuAnimalia(izena)) {
            sceneManager.erakutsiNagusia(izena + " zoriontasunez adoptatu da!\n");
        } else {
            view.erakutsiErrorea("Errorea: " + izena + " ez da aurkitu edo jada adoptatuta dago.");
        }
    }

    public void utzi() {
        sceneManager.erakutsiNagusia(null);
    }
}
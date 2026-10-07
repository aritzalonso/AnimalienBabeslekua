// EzabatuController.java
package org.example;

public class EzabatuController {
    private Babeslekua model;
    private EzabatuView view;
    private SceneManager sceneManager;

    public EzabatuController(Babeslekua model, EzabatuView view, SceneManager sceneManager) {
        this.model = model;
        this.view = view;
        this.sceneManager = sceneManager;
    }

    public void ezabatu() {
        String izena = view.getIzena().trim();
        if (izena.isEmpty()) {
            view.erakutsiErrorea("Sartu izen bat mesedez.");
            return;
        }

        if (model.ezabatuAnimalia(izena)) {
            sceneManager.erakutsiNagusia(izena + " ongi ezabatu da.\n");
        } else {
            view.erakutsiErrorea("Errorea: Ez da " + izena + " izeneko animaliarik aurkitu.");
        }
    }

    public void utzi() {
        sceneManager.erakutsiNagusia(null);
    }
}
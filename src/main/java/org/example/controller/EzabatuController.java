// EzabatuController.java (org.example.controller paketean)
package org.example.controller;

import org.example.Babeslekua;
import org.example.SceneManager;
import org.example.view.EzabatuView;

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
            model.gehituErregistroa(izena + " ongi ezabatu da.");
            sceneManager.erakutsiNagusia();
        } else {
            view.erakutsiErrorea("Errorea: Ez da " + izena + " izeneko animaliarik aurkitu.");
        }
    }

    public void utzi() {
        sceneManager.erakutsiNagusia();
    }
}
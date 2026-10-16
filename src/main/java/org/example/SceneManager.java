// SceneManager.java
package org.example;

import javafx.scene.Scene;
import org.example.controller.AdoptatuController;
import org.example.controller.EzabatuController;
import org.example.controller.GehituController;
import org.example.controller.NagusiaController;
import org.example.view.AdoptatuView;
import org.example.view.EzabatuView;
import org.example.view.GehituView;
import org.example.view.NagusiaView;

public class SceneManager {
    private Scene scene;
    private Babeslekua model;

    public SceneManager(Scene scene, Babeslekua model) {
        this.scene = scene;
        this.model = model;
        erakutsiNagusia();
    }

    public void erakutsiNagusia() {
        NagusiaView view = new NagusiaView();
        NagusiaController controller = new NagusiaController(model, view, this);
        view.setController(controller);
        scene.setRoot(view);
    }

    public void erakutsiGehitu() {
        GehituView view = new GehituView();
        GehituController controller = new GehituController(model, view, this);
        view.setController(controller);
        scene.setRoot(view);
    }

    public void erakutsiAdoptatu() {
        AdoptatuView view = new AdoptatuView();
        AdoptatuController controller = new AdoptatuController(model, view, this);
        view.setController(controller);
        scene.setRoot(view);
    }

    public void erakutsiEzabatu() {
        EzabatuView view = new EzabatuView();
        EzabatuController controller = new EzabatuController(model, view, this);
        view.setController(controller);
        scene.setRoot(view);
    }
}
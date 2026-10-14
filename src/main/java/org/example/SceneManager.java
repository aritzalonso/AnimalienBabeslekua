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
    private NagusiaView nagusiaView;

    public SceneManager(Scene scene, Babeslekua model) {
        this.scene = scene;
        this.model = model;

        this.nagusiaView = new NagusiaView();
        NagusiaController nagusiaController = new NagusiaController(this.model, this.nagusiaView, this);
        this.nagusiaView.setController(nagusiaController);

        erakutsiNagusia(null);
    }

    public void erakutsiNagusia(String mezuBerria) {
        if (mezuBerria != null && !mezuBerria.isEmpty()) {
            nagusiaView.gehituMezua(mezuBerria);
        }
        scene.setRoot(nagusiaView);
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
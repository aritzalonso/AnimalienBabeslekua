// SceneManager.java
package org.example;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {
    private Stage stage;
    private Babeslekua model;

    // Guardamos la vista principal para no perder el historial del TextArea
    private Scene nagusiaScene;
    private NagusiaView nagusiaView;

    public SceneManager(Stage stage, Babeslekua model) {
        this.stage = stage;
        this.model = model;
        this.stage.setTitle("Animalien Babeslekua");

        // Inicializar la vista principal y su controlador
        this.nagusiaView = new NagusiaView();
        NagusiaController nagusiaController = new NagusiaController(this.model, this.nagusiaView, this);
        this.nagusiaView.setController(nagusiaController);

        this.nagusiaScene = new Scene(nagusiaView, 700, 500);
    }

    public void erakutsiNagusia(String mezuBerria) {
        if (mezuBerria != null && !mezuBerria.isEmpty()) {
            nagusiaView.gehituMezua(mezuBerria);
        }
        stage.setScene(nagusiaScene);
        stage.show();
    }

    public void erakutsiGehitu() {
        GehituView view = new GehituView();
        GehituController controller = new GehituController(model, view, this);
        view.setController(controller);
        stage.setScene(new Scene(view, 700, 500));
    }

    public void erakutsiAdoptatu() {
        AdoptatuView view = new AdoptatuView();
        AdoptatuController controller = new AdoptatuController(model, view, this);
        view.setController(controller);
        stage.setScene(new Scene(view, 700, 500));
    }

    public void erakutsiEzabatu() {
        EzabatuView view = new EzabatuView();
        EzabatuController controller = new EzabatuController(model, view, this);
        view.setController(controller);
        stage.setScene(new Scene(view, 700, 500));
    }
}
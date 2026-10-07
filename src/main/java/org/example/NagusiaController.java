
package org.example;

import javafx.application.Platform;

public class NagusiaController {
    private Babeslekua model;
    private NagusiaView view;
    private SceneManager sceneManager;

    public NagusiaController(Babeslekua model, NagusiaView view, SceneManager sceneManager) {
        this.model = model;
        this.view = view;
        this.sceneManager = sceneManager;
    }

    public void gehitu() {
        sceneManager.erakutsiGehitu();
    }

    public void erakutsi() {
        view.gehituMezua(model.erakutsiAnimaliak() + "\n");
    }

    public void adoptatu() {
        sceneManager.erakutsiAdoptatu();
    }

    public void ezabatu() {
        sceneManager.erakutsiEzabatu();
    }

    public void soinuaEgin() {
        view.gehituMezua(model.eginSoinuak() + "\n");
    }

    public void txakurraLotu() {
        view.gehituMezua("A-TA PERROOOO!!\n");
    }

    public void irten() {
        Platform.exit();
    }
}
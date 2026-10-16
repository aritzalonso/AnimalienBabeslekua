// NagusiaController.java (org.example.controller paketean)
package org.example.controller;

import javafx.application.Platform;
import org.example.Babeslekua;
import org.example.SceneManager;
import org.example.view.NagusiaView;

public class NagusiaController {
    private Babeslekua model;
    private NagusiaView view;
    private SceneManager sceneManager;

    public NagusiaController(Babeslekua model, NagusiaView view, SceneManager sceneManager) {
        this.model = model;
        this.view = view;
        this.sceneManager = sceneManager;
        this.view.setTestua(model.getErregistroa());
    }

    public void gehitu() {
        sceneManager.erakutsiGehitu();
    }

    public void erakutsi() {
        model.gehituErregistroa(model.erakutsiAnimaliak());
        view.setTestua(model.getErregistroa());
    }

    public void adoptatu() {
        sceneManager.erakutsiAdoptatu();
    }

    public void ezabatu() {
        sceneManager.erakutsiEzabatu();
    }

    public void soinuaEgin() {
        model.gehituErregistroa(model.eginSoinuak());
        view.setTestua(model.getErregistroa());
    }

    public void txakurraLotu() {
        model.gehituErregistroa("A-TA PERROOOO!!");
        view.setTestua(model.getErregistroa());
    }

    public void irten() {
        Platform.exit();
    }
}
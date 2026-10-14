// BabeslekuaApp.java
package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class BabeslekuaApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        Babeslekua model = new Babeslekua();

        SceneManager sceneManager = new SceneManager(primaryStage.getScene(), model);

        sceneManager.erakutsiNagusia(null);
    }
}
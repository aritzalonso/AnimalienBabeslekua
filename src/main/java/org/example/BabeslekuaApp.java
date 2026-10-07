// BabeslekuaApp.java
package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class BabeslekuaApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Instanciamos el modelo principal
        Babeslekua model = new Babeslekua();

        // Creamos el SceneManager que gestionará todas las vistas
        SceneManager sceneManager = new SceneManager(primaryStage, model);

        // Iniciamos la aplicación mostrando el menú principal
        sceneManager.erakutsiNagusia(null);
    }
}
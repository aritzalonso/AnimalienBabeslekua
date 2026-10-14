// Main.java
package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Babeslekua model = new Babeslekua();

        Scene scene = new Scene(new Pane(), 700, 500);
        new SceneManager(scene, model);

        stage.setTitle("Animalien Babeslekua");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
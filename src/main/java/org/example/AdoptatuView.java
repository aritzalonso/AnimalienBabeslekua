// AdoptatuView.java
package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AdoptatuView extends BorderPane {
    private TextField izenaField;
    private Label erroreLabel;
    private Button btnAdos;
    private Button btnUtzi;

    public AdoptatuView() {
        VBox centerBox = new VBox(30);
        centerBox.setPadding(new Insets(40));
        centerBox.setAlignment(Pos.TOP_CENTER);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        izenaField = new TextField();
        grid.add(new Label("Izena:"), 0, 0);
        grid.add(izenaField, 1, 0);

        erroreLabel = new Label("");
        erroreLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

        Label tituluLabel = new Label("Zein da adoptatu nahi duzun animaliaren izena?");
        tituluLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        centerBox.getChildren().addAll(tituluLabel, grid, erroreLabel);
        this.setCenter(centerBox);

        HBox bottomBox = new HBox(15);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(20));

        btnAdos = new Button("Ados");
        btnUtzi = new Button("Utzi");
        bottomBox.getChildren().addAll(btnAdos, btnUtzi);
        this.setBottom(bottomBox);
    }

    public void setController(AdoptatuController controller) {
        btnAdos.setOnAction(e -> controller.adoptatu());
        btnUtzi.setOnAction(e -> controller.utzi());
    }

    public String getIzena() { return izenaField.getText(); }
    public void erakutsiErrorea(String mezua) { erroreLabel.setText(mezua); }
}
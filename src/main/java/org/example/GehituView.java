
package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GehituView extends BorderPane {
    private ComboBox<String> motaBox;
    private TextField izenaField;
    private TextField adinaField;
    private TextField pisuaField;
    private Label erroreLabel;
    private Button btnAdos;
    private Button btnUtzi;

    public GehituView() {
        // Centro (Formulario)
        VBox centerBox = new VBox(30);
        centerBox.setPadding(new Insets(40));
        centerBox.setAlignment(Pos.TOP_CENTER);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        motaBox = new ComboBox<>();
        motaBox.getItems().addAll("Txakurra", "Katua", "Untxia");
        motaBox.getSelectionModel().selectFirst();

        izenaField = new TextField();
        adinaField = new TextField();
        pisuaField = new TextField();

        grid.add(new Label("Mota:"), 0, 0);
        grid.add(motaBox, 1, 0);
        grid.add(new Label("Izena:"), 0, 1);
        grid.add(izenaField, 1, 1);
        grid.add(new Label("Adina:"), 0, 2);
        grid.add(adinaField, 1, 2);
        grid.add(new Label("Pisua (kg):"), 0, 3);
        grid.add(pisuaField, 1, 3);

        erroreLabel = new Label("");
        erroreLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");

        Label tituluLabel = new Label("Sartu animalia berriaren datuak:");
        tituluLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        centerBox.getChildren().addAll(tituluLabel, grid, erroreLabel);
        this.setCenter(centerBox);

        // Abajo (Botones)
        HBox bottomBox = new HBox(15);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setPadding(new Insets(20));

        btnAdos = new Button("Ados");
        btnUtzi = new Button("Utzi");
        bottomBox.getChildren().addAll(btnAdos, btnUtzi);
        this.setBottom(bottomBox);
    }

    public void setController(GehituController controller) {
        btnAdos.setOnAction(e -> controller.gorde());
        btnUtzi.setOnAction(e -> controller.utzi());
    }

    public String getMota() { return motaBox.getValue(); }
    public String getIzena() { return izenaField.getText(); }
    public String getAdina() { return adinaField.getText(); }
    public String getPisua() { return pisuaField.getText(); }
    public void erakutsiErrorea(String mezua) { erroreLabel.setText(mezua); }
}
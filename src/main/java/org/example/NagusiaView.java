
package org.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class NagusiaView extends BorderPane {
    private TextArea testuEremua;
    private Button btnGehitu, btnErakutsi, btnAdoptatu, btnEzabatu, btnSoinua, btnTxakurraLotu, btnIrten;

    public NagusiaView() {
        testuEremua = new TextArea();
        testuEremua.setEditable(false);
        testuEremua.setWrapText(true);
        testuEremua.setStyle("-fx-font-size: 14px; -fx-font-family: 'Consolas';");
        this.setCenter(testuEremua);
        testuEremua.appendText("Ongi etorri Animalien Babeslekura!\n====================================\n");

        VBox botoiPanela = new VBox(10);
        botoiPanela.setPadding(new Insets(15));
        botoiPanela.setAlignment(Pos.TOP_CENTER);
        botoiPanela.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #cccccc; -fx-border-width: 0 1 0 0;");

        btnGehitu = new Button("1. Animalia gehitu");
        btnErakutsi = new Button("2. Animalia erakutsi");
        btnAdoptatu = new Button("3. Animalia adoptatu");
        btnEzabatu = new Button("4. Animalia ezabatu");
        btnSoinua = new Button("5. Guztiek soinua egin");
        btnTxakurraLotu = new Button("6. Txakurra lotu");
        btnIrten = new Button("0. Irten");

        Button[] botoiak = {btnGehitu, btnErakutsi, btnAdoptatu, btnEzabatu, btnSoinua, btnTxakurraLotu, btnIrten};
        for (Button btn : botoiak) {
            btn.setMaxWidth(Double.MAX_VALUE);
            botoiPanela.getChildren().add(btn);
        }

        this.setLeft(botoiPanela);
    }

    public void setController(NagusiaController controller) {
        btnGehitu.setOnAction(e -> controller.gehitu());
        btnErakutsi.setOnAction(e -> controller.erakutsi());
        btnAdoptatu.setOnAction(e -> controller.adoptatu());
        btnEzabatu.setOnAction(e -> controller.ezabatu());
        btnSoinua.setOnAction(e -> controller.soinuaEgin());
        btnTxakurraLotu.setOnAction(e -> controller.txakurraLotu());
        btnIrten.setOnAction(e -> controller.irten());
    }

    public void gehituMezua(String mezua) {
        testuEremua.appendText(mezua);
    }
}
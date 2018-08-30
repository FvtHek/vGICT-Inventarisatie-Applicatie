/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangemerdenict.invapp;

import com.vangemerdenict.invapp.InlezenMainController;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Frans
 */
public class AlertBox {
    
    @FXML
    private AnchorPane MainPane;

    String selectedItem = MainApp.getSelectedItem();

    public static void display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setHeight(200);

        Label label = new Label();
        label.setText(message);

        Button cancelButton = new Button("Annuleren");
        cancelButton.setOnAction(e -> window.close());
        Button deleteButton = new Button("Verwijderen");
        deleteButton.setOnAction(e -> {
            MainApp.deleteSelectedItem();
            window.close();
                });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, cancelButton, deleteButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    private void loadPage(String name) {
        String fxmlFileLocation = String.format("/fxml/%s", name);

        try {
            Parent pane = loadFXMLFile(fxmlFileLocation);

            MainPane.getChildren().clear();

            MainPane.getChildren().add(pane);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Parent loadFXMLFile(String fxmlFileLocation) {
        try {
            return FXMLLoader.load(MainApp.class.getResource(fxmlFileLocation));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}

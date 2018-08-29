package com.vangemerdenict.invapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MainMenuController implements Initializable {

    @FXML
    private Button btn_inlezen;
    private Button btn_uitboeken;
    private Button btn_archief;

    @FXML
    private AnchorPane MainPane;


    @FXML
    private void menuButtonInlezenClick(ActionEvent event) {
        loadPage("InlezenMain.fxml");
    }

    @FXML
    private void menuButtonUitboekenClick(ActionEvent event) {
        loadPage("UitboekenMain.fxml");
    }

    @FXML
    private void menuButtonArchiefClick(ActionEvent event) {
        loadPage("ArchiefMain.fxml");
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

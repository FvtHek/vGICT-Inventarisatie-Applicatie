package com.vangemerdenict.invapp;

import db.MyJDBC;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MainApp extends Application {
    
    @FXML
    private AnchorPane MainPane;
    
    public static MyJDBC db;

    @Override
    public void start(Stage stage) throws Exception {
        initMyApp();
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("InvApp");
        stage.setScene(scene);
        stage.show();
    }
    
     private void initMyApp()
    {
        System.out.println("INIT DATABASE");
        
        db = new MyJDBC();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

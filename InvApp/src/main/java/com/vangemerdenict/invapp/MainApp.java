package com.vangemerdenict.invapp;

import db.MyJDBC;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private static String selectedItem;
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

    private void initMyApp() {
        db = new MyJDBC();

        System.out.println("INITIALIZING DATABASE");
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() {
        db.close();
    }

    /**
     * @return the selectedItem
     */
    public static String getSelectedItem() {
        return selectedItem;
    }

    /**
     * @param aSelectedItem the selectedItem to set
     */
    public static void setSelectedItem(String aSelectedItem) {
        selectedItem = aSelectedItem;
    }
}

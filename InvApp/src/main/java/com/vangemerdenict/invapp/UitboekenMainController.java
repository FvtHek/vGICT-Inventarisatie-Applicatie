/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangemerdenict.invapp;

import Util.InventoryList;
import com.vangemerdenict.invapp.UitboekenUpdateController;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Frans
 */
public class UitboekenMainController implements Initializable {

    @FXML
    private AnchorPane MainPane;
    @FXML
    private TableView<InventoryList> table;
    @FXML
    private TableColumn<InventoryList, String> col_id;
    @FXML
    private TableColumn<InventoryList, String> col_naam;
    @FXML
    private TableColumn<InventoryList, String> col_barcode;
    @FXML
    private TableColumn<InventoryList, String> col_type;
    @FXML
    private TableColumn<InventoryList, String> col_merk;
    @FXML
    private TableColumn<InventoryList, String> col_ingekocht;
    @FXML
    private TableColumn<InventoryList, String> col_inkoopprijs;
    @FXML
    private TableColumn<InventoryList, String> col_grVerloopt;
    @FXML
    private TableColumn<InventoryList, String> col_specs;
    @FXML
    private TableColumn<InventoryList, String> col_opmerking;

    ObservableList<InventoryList> data = FXCollections.observableArrayList();

    private String selectedItem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadDataFromDatabase();
        selectItem();

    }

    private void loadDataFromDatabase() {
        String query = String.format("select * from product where verkocht = '0';");

        try {
            ResultSet rs = MainApp.db.executeResultSetQuery(query);

            while (rs.next()) {
                data.add(new InventoryList("" + rs.getInt("id"), rs.getString("naam"), rs.getString("barcode"), rs.getString("type product"), rs.getString("merk"), rs.getString("ingekocht"), rs.getDouble("inkoopprijs"), rs.getString("garantie verloopt op"), rs.getString("specs"), rs.getString("opmerking")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UitboekenMainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        setCellTable();

        table.setItems(data);
    }

    private void selectItem() {
        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                InventoryList il = table.getItems().get(table.getSelectionModel().getSelectedIndex());
                selectedItem = il.getId();
                System.out.println(selectedItem);
                MainApp.setSelectedItem(selectedItem);
            }
        });
    }

    private void setCellTable() {
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_naam.setCellValueFactory(new PropertyValueFactory<>("naam"));
        col_barcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_merk.setCellValueFactory(new PropertyValueFactory<>("merk"));
        col_ingekocht.setCellValueFactory(new PropertyValueFactory<>("ingekocht"));
        col_inkoopprijs.setCellValueFactory(new PropertyValueFactory<>("inkoopprijs"));
        col_grVerloopt.setCellValueFactory(new PropertyValueFactory<>("grVerloopt"));
        col_specs.setCellValueFactory(new PropertyValueFactory<>("specs"));
        col_opmerking.setCellValueFactory(new PropertyValueFactory<>("opmerking"));
    }

    public Parent loadFXMLFile(String fxmlFileLocation) {
        try {
            return FXMLLoader.load(MainApp.class.getResource(fxmlFileLocation));
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @FXML
    public void itemUpdateClick(ActionEvent event) {
        loadPage("UitboekenUpdate.fxml");
        System.out.println("ACTION: Loading Uitboeken Form.");
    }

    @FXML
    public void menuButtonMenuClick(ActionEvent event) {
        loadPage("MainMenu.fxml");
        System.out.println("ACTION: Loading Main Menu.");
    }

    @FXML
    public void menuButtonInlezenClick(ActionEvent event) {
        loadPage("InlezenMain.fxml");
        System.out.println("ACTION: Loading Inlezen Page.");
    }

    @FXML
    public void menuButtonArchiefClick(ActionEvent event) {
        loadPage("ArchiefMain.fxml");
        System.out.println("ACTION: Loading Archief Page.");
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

}

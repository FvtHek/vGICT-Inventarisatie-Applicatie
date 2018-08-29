/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangemerdenict.invapp;

import Util.InventoryList;
import com.vangemerdenict.invapp.MainApp;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Frans
 */
public class ArchiefUpdateController implements Initializable {

    @FXML
    private AnchorPane MainPane;
    @FXML
    private TextField field_merk;
    @FXML
    private TextField field_barcode;
    @FXML
    private TextField field_inkoopprijs;
    @FXML
    private TextField field_naam;
    @FXML
    private TextArea field_specs;
    @FXML
    private TextArea field_opmerking;
    @FXML
    private TextField field_type;
    @FXML
    private TextField field_ingekocht;
    @FXML
    private TextField field_grVerloopt;
    @FXML
    private TextField field_klant;
    @FXML
    private TextField field_verkoopprijs;
    @FXML
    private TextField field_verkoopDatum;
    @FXML
    private Button btn_cancel;
    @FXML
    private Button btn_save;

    private String selectedItem = MainApp.getSelectedItem();

    InventoryList inventoryList;

    private int verkocht = 1;

    @FXML
    private void saveFormClick(ActionEvent event) {
        saveform();

        Parent pane = loadFXMLFile("/fxml/ArchiefMain.fxml");
        System.out.println("ACTION: Save Update Form.");

        MainPane.getChildren().clear();

        MainPane.getChildren().add(pane);
    }

    @FXML
    private void cancelFormClick(ActionEvent event) {
        Parent pane = loadFXMLFile("/fxml/ArchiefMain.fxml");
        System.out.println("ACTION: Cancel Update Form.");

        MainPane.getChildren().clear();

        MainPane.getChildren().add(pane);
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
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(selectedItem);
        try {
            loadSelectedItem(selectedItem);
        } catch (SQLException ex) {
            Logger.getLogger(ArchiefUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadSelectedItem(String selectedItem) throws SQLException {
        String query = String.format("SELECT *\n"
                + "FROM `mydb`.`product`\n"
                + "WHERE `id` = %s;", selectedItem);

        ResultSet rs = MainApp.db.executeResultSetQuery(query);

        while (rs.next()) {
            inventoryList = new InventoryList("" + rs.getInt("id"), rs.getString("naam"), rs.getString("barcode"), rs.getString("type product"), rs.getString("merk"), rs.getString("ingekocht"), rs.getDouble("inkoopprijs"), rs.getString("verkocht op"), rs.getDouble("verkoopprijs"), rs.getString("garantie verloopt op"), rs.getString("specs"), rs.getString("opmerking"), rs.getString("klant"));
        }

        fillTextFields(inventoryList);
    }

    private void fillTextFields(InventoryList inventoryList) {
        field_naam.setText(inventoryList.getNaam());
        field_barcode.setText(inventoryList.getBarcode());
        field_type.setText(inventoryList.getType());
        field_merk.setText(inventoryList.getMerk());
        field_ingekocht.setText(inventoryList.getIngekocht());
        field_inkoopprijs.setText("" + inventoryList.getInkoopprijsDouble());
        field_grVerloopt.setText(inventoryList.getGrVerloopt());
        field_specs.setText(inventoryList.getSpecs());
        field_opmerking.setText(inventoryList.getOpmerking());
        field_klant.setText(inventoryList.getKlant());
        field_verkoopprijs.setText("" + inventoryList.getVerkoopprijsDouble());
        field_verkoopDatum.setText(inventoryList.getVerkoopDatum());
    }

    private void saveform() {

        String verkoopDatum = field_verkoopDatum.getText();
        String verkoopprijs = field_verkoopprijs.getText();
        String klant = field_klant.getText();
        String naam = field_naam.getText();
        String barcode = field_barcode.getText();
        String merk = field_merk.getText();
        String type = field_type.getText();
        String ingekocht = field_ingekocht.getText();
        String inkoopprijs = field_inkoopprijs.getText();
        String grVerloopt = field_grVerloopt.getText();
        String opmerking = field_opmerking.getText();
        String specs = field_specs.getText();

        String query = String.format("UPDATE `mydb`.`product`\n"
                + "SET\n"
                + "`naam` = '%s',\n"
                + "`barcode` = '%s',\n"
                + "`type product` = '%s',\n"
                + "`merk` = '%s',\n"
                + "`ingekocht` = '%s',\n"
                + "`verkocht op` = '%s',\n"
                + "`garantie verloopt op` = '%s',\n"
                + "`specs` = '%s',\n"
                + "`opmerking` = '%s',\n"
                + "`klant` = '%s',\n"
                + "`inkoopprijs` = %s,\n"
                + "`verkoopprijs` = %s\n"
                + "WHERE `id` = %s;", naam, barcode, type, merk, ingekocht, verkoopDatum, grVerloopt, specs, opmerking, klant, inkoopprijs, verkoopprijs, selectedItem);

        MainApp.db.executeUpdateQuery(query);
    }

}

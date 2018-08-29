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
public class UitboekenUpdateController implements Initializable {
    
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
    private DatePicker field_verkoopDatum;
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

        Parent pane = loadFXMLFile("/fxml/UitboekenMain.fxml");
        System.out.println("ACTION: Save Update Form.");

        MainPane.getChildren().clear();

        MainPane.getChildren().add(pane);
    }
    
    @FXML
    private void cancelFormClick(ActionEvent event) {
        Parent pane = loadFXMLFile("/fxml/UitboekenMain.fxml");
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
            Logger.getLogger(UitboekenUpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadSelectedItem(String selectedItem) throws SQLException {
        String query = String.format("SELECT `product`.`id`,\n"
                + "    `product`.`naam`,\n"
                + "    `product`.`barcode`,\n"
                + "    `product`.`type product`,\n"
                + "    `product`.`merk`,\n"
                + "    `product`.`ingekocht`,\n"
                + "    `product`.`garantie verloopt op`,\n"
                + "    `product`.`specs`,\n"
                + "    `product`.`verkocht`,\n"
                + "    `product`.`opmerking`,\n"
                + "    `product`.`inkoopprijs`\n"
                + "FROM `mydb`.`product`\n"
                + "WHERE `id` = %s;", selectedItem);
        
        ResultSet rs = MainApp.db.executeResultSetQuery(query);
        
        while (rs.next()) {
            inventoryList = new InventoryList("" + rs.getInt("id"), rs.getString("naam"), rs.getString("barcode"), rs.getString("type product"), rs.getString("merk"), rs.getString("ingekocht"), rs.getDouble("inkoopprijs"), rs.getString("garantie verloopt op"), rs.getString("specs"), rs.getString("opmerking"));
        }
        
        fillTextFields(inventoryList);
    }
    
    private void fillTextFields(InventoryList inventoryList) {
        field_naam.setText(inventoryList.getNaam());
        field_barcode.setText(inventoryList.getBarcode());
        field_type.setText(inventoryList.getType());
        field_merk.setText(inventoryList.getMerk());
        field_ingekocht.setText(inventoryList.getIngekocht());
        field_inkoopprijs.setText(inventoryList.getInkoopprijs());
        field_grVerloopt.setText(inventoryList.getGrVerloopt());
        field_specs.setText(inventoryList.getSpecs());
        field_opmerking.setText(inventoryList.getOpmerking());
    }
    
    private void saveform() {
        
        LocalDate verkoopDatum = field_verkoopDatum.getValue();
        String verkoopprijs = field_verkoopprijs.getText();
        String klant = field_klant.getText();
        
        String query = String.format("UPDATE `mydb`.`product`\n"
                + "SET\n"
                + "`verkocht op` = '%s',\n"
                + "`verkocht` = %d,\n"
                + "`klant` = '%s',\n"
                + "`verkoopprijs` = %s\n"
                + "WHERE `id` = %s;", verkoopDatum, verkocht, klant, verkoopprijs, selectedItem);
        
        MainApp.db.executeUpdateQuery(query);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangemerdenict.invapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;

/**
 *
 * @author Frans
 */
public class InlezenInsertController implements Initializable {

    @FXML
    private AnchorPane MainPane;
    @FXML
    private TextField field_merk;
    @FXML
    private TextField field_barcode;
    @FXML
    private TextField field_naam;
    @FXML
    private ChoiceBox<String> field_type;
    @FXML
    private Button btn_addType;
    @FXML
    private DatePicker field_ingekocht;
    @FXML
    private TextField field_inkoopprijs;
    @FXML
    private DatePicker field_grVerloopt;
    @FXML
    private TextArea field_specs;
    @FXML
    private TextArea field_opmerking;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTypeList(field_type);
    }

    public ArrayList<String> typeList() {
        String query = String.format("select type from mydb.type;");

        String type = null;

        ResultSet rs;
        try {
            rs = MainApp.db.executeResultSetQuery(query);

            ArrayList<String> typeList = new ArrayList<>();

            while (rs.next()) {
                type = rs.getString("type");
                typeList.add(type);
            }

            return (typeList);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void fillTypeList(ChoiceBox field) {
        ArrayList<String> typeList = typeList();

        for (String typeList1 : typeList) {
            field.getItems().addAll(typeList1);
        }
    }

    @FXML
    private void saveFormClick(ActionEvent event) {

        String naam = field_naam.getText();
        String barcode = field_barcode.getText();
        String merk = field_merk.getText();
        String type = field_type.getSelectionModel().getSelectedItem();
        LocalDate ingekocht = field_ingekocht.getValue();
        String inkoopprijs = field_inkoopprijs.getText();
        LocalDate grVerloopt = field_grVerloopt.getValue();
        String specs = field_specs.getText();

        int verkocht = 0;

        String opmerking;
        if (field_opmerking.getText() != null) {
            opmerking = field_opmerking.getText();
        } else {
            opmerking = null;
        }

        System.out.println("ACTION: Saving New Item");

        String query = String.format("INSERT INTO `mydb`.`product`(`naam`,`barcode`,`type product`,`merk`,`ingekocht`,`inkoopprijs`,`garantie verloopt op`,`specs`,`verkocht`,`opmerking`)VALUES "
                + "('%s','%s','%s','%s','%s',%s,'%s','%s',%d,'%s');", naam, barcode, type, merk, ingekocht, inkoopprijs, grVerloopt, specs, verkocht, opmerking);

        System.out.println(query);

        MainApp.db.executeUpdateQuery(query);

        System.out.println("Form Saved");

        Parent pane = loadFXMLFile("/fxml/InlezenMain.fxml");

        MainPane.getChildren().clear();

        MainPane.getChildren().add(pane);
    }

    @FXML
    private void cancelFormClick(ActionEvent event) {
        Parent pane = loadFXMLFile("/fxml/InlezenMain.fxml");
        System.out.println("ACTION: Cancel New Item.");

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

}

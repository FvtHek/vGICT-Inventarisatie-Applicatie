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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Util.TypeList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author Frans
 */
public class InlezenInsertController implements Initializable{
    @FXML
    private AnchorPane MainPane;
    @FXML
    private TextField field_merk;
    @FXML
    private Label lbl_type;
    @FXML
    private TextField field_barcode;
    @FXML
    private Label lbl_barcode;
    @FXML
    private ChoiceBox<String> field_type;
    @FXML
    private Button btn_addType;
    @FXML
    private Label lbl_type1;
    @FXML
    private Label lbl_type11;
    @FXML
    private Label lbl_type111;
    @FXML
    private DatePicker field_ingekocht;
    @FXML
    private DatePicker field_grVerloopt;
    @FXML
    private Label lbl_barcode1;
    @FXML
    private Label lbl_barcode11;
    @FXML
    private TextField field_specs;
    @FXML
    private TextField field_opmerking;
    @FXML
    private Button btn_cancel;
    @FXML
    private Button btn_save;
    
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
        
        for (int i = 0; i < typeList.size(); i++) {
            field.getItems().addAll(typeList.get(i));
        }
    }
    
    
}

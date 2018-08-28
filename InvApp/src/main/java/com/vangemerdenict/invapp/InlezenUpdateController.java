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

/**
 * FXML Controller class
 *
 * @author Frans
 */
public class InlezenUpdateController implements Initializable {
    @FXML
    private AnchorPane MainPane;
    @FXML
    private TextField field_opmerking;
    @FXML
    private TextField field_merk;
    @FXML
    private Label lbl_type;
    @FXML
    private TextField field_barcode;
    @FXML
    private Label lbl_barcode;
    @FXML
    private ChoiceBox<?> field_type;
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
    private Button btn_cancel;
    @FXML
    private Button btn_save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

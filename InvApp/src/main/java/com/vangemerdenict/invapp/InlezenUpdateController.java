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
    private TextField field_id;
    @FXML
    private TextField field_datatest;
    @FXML
    private TextField field_opmerking;
    @FXML
    private Label lbl_opmerking;
    @FXML
    private Label lbl_datatest;
    @FXML
    private Label lbl_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

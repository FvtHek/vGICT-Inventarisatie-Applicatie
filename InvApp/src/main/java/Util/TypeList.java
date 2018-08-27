/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.vangemerdenict.invapp.MainApp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.scene.control.ChoiceBox;

/**
 *
 * @author Frans
 */
public class TypeList {

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

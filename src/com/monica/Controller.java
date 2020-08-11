package com.monica;

import com.monica.model.Datasource;
import com.monica.model.PotLuck;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TableView potluckTable;
    @FXML
    private TextField columnName;
    @FXML
    private TextField columnValue;


    @FXML
    public void listPotluck(){

        String name = columnName.getText();
        String value = columnValue.getText();

        if(name.isEmpty() || value.isEmpty()){
            System.out.println("Couldn't finish query");
        }else{
            ObservableList<PotLuck> potluckList = FXCollections.observableArrayList(
                    Datasource.getInstance().queryPotLuck(name,value));
            potluckTable.setItems(potluckList);
            for(PotLuck potLuck : potluckList){
                System.out.println(potLuck.toString());
            }
        }

    }
}

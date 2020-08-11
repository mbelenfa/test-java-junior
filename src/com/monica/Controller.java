package com.monica;

import com.monica.model.Datasource;
import com.monica.model.PotLuck;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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

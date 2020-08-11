package com.monica;

import com.monica.model.Datasource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.util.Collections;

public class Main extends Application {

    @Override
    public void init() throws Exception {
        super.init();
        if(!Datasource.getInstance().open()){
            System.out.println("FATAL ERROR: Couldn't connect to database");
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Datasource.getInstance().close();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.listPotluck();

        primaryStage.setTitle("PotLuck Database");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

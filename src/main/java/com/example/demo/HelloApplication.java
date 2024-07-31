package com.example.demo;

import com.example.demo.ParkV.DBManager;
import com.example.demo.ParkV.DatabaseConnection;
import com.example.demo.ParkV.Park;
import com.example.demo.ParkV.Vehicule;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloController.class.getResource("zone.fxml"));
        Parent root = loader.load();
        // Créer la scène et l'afficher
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Park Vehicule");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
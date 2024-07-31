package com.example.demo;

import com.example.demo.ParkV.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.NodeList;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField recherche_voiture;
    @FXML
    private TextField mark_voiture;
    @FXML
    private ComboBox<Integer> id_voiture;
    @FXML
    private ComboBox<String> type_choix;
    @FXML
    private Label titre;
    @FXML
    private TableView<Vehicule> table = new TableView<>();
    private Park pkl;

    public HelloController(){

        this.pkl = new Park();

    }
    public void look(){
        String t = this.recherche_voiture.getText();
        if(t.length() > 0){
            this.table.getItems().clear();
            this.id_voiture.getSelectionModel().clearSelection();
            this.id_voiture.getItems().clear();
            Map<Integer, Vehicule> l = this.pkl.lookVehicule(t);
            for(Map.Entry<Integer,Vehicule> x:l.entrySet()){

                this.table.getItems().add(x.getValue());
                this.id_voiture.getItems().add(x.getValue().getId());
            }
            this.table.getColumns().get(0).setSortType(TableColumn.SortType.DESCENDING);
            this.id_voiture.getSelectionModel().selectFirst();
        }else{

            this.Actualise();
        }
    }
    @FXML
    public void Actualise(){

        this.table.getItems().clear();
        this.id_voiture.getSelectionModel().clearSelection();
        this.id_voiture.getItems().clear();

        Map<Integer,Vehicule> v = this.pkl.printl();
        for(Map.Entry<Integer,Vehicule> x:v.entrySet()){

            this.table.getItems().add(x.getValue());
            this.id_voiture.getItems().add(x.getValue().getId());
        }
        this.table.getColumns().get(0).setSortType(TableColumn.SortType.DESCENDING);
        this.id_voiture.getSelectionModel().selectFirst();
    }
    @FXML
    public void supprimerVoiture(){


        int id = this.id_voiture.getValue();
        this.pkl.rmVoiture(id);
        this.Actualise();
    }
    @FXML
    public void  newCar(){

        String mark = this.mark_voiture.getText();
        String type = this.type_choix.getValue();
        Vehicule v = new Vehicule(type,mark);
        boolean r = this.pkl.nvVoiture(v);
        this.Actualise();
        this.mark_voiture.setText("");
        this.type_choix.getSelectionModel().selectFirst();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Map<Integer,Vehicule> v = this.pkl.printl();
        // initialisation du combo box
        this.type_choix.getItems().add("Voiture");
        this.type_choix.getItems().add("Camion");
        this.type_choix.getItems().add("Moto");
        this.type_choix.getSelectionModel().selectFirst();
        //initalisation du tableau
        this.table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("num"));
        this.table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("id"));
        this.table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type"));
        this.table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("mark"));

        this.table.getColumns().get(0).setSortType(TableColumn.SortType.DESCENDING);
        this.table.getColumns().get(1).setSortable(false);
        this.table.getColumns().get(2).setSortable(false);
        this.table.getColumns().get(3).setSortable(false);


        for(Map.Entry<Integer,Vehicule> x:v.entrySet()){

            this.table.getItems().add(x.getValue());
            this.id_voiture.getItems().add(x.getValue().getId());
        }

        this.id_voiture.getSelectionModel().selectFirst();
    }
}
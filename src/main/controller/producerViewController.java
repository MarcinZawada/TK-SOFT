package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.DbConnector;
import main.Main;//kadhsj

import java.net.URL;
import java.util.ResourceBundle;

public class producerViewController implements Initializable {
    private Main main;
    private DbConnector db;
    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.goToView("view/startView.fxml");
    }
    public void clients(ActionEvent event) throws Exception {
        main.goToView("view/clientView.fxml");
    }
    public void orders(ActionEvent event) throws Exception {
        main.goToView("view/orderView.fxml");
    }
    public void products(ActionEvent event) throws Exception {
        main.goToView("view/productView.fxml");
    }
    public void producers(ActionEvent event) throws Exception {
        main.goToView("view/producerView.fxml");
    }
    @FXML
    public void findproducer(ActionEvent event) throws Exception {
        main.goToView("view/findProducerView.fxml");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DbConnector();
    }
}
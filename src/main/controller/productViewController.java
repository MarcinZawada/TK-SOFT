package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.Main;//kadhsj

public class productViewController {
    private Main main;
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
    public void findproduct(ActionEvent event) throws Exception {
        main.goToView("view/findProductView.fxml");
    }
}
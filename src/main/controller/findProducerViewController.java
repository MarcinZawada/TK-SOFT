package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.Main;//kadhsj

public class findProducerViewController {
    private Main main;
    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.goToView("view/startView.fxml");
    }
    @FXML
    public void goBack(ActionEvent event) throws Exception {
        main.goToView("view/homeWorkerView.fxml");
    }
}
package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.Main;//kadhsj

public class addEmployeeViewController {
    private Main main;
    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.goToView("view/startView.fxml");
    }
    public void goWorker(ActionEvent event) throws Exception {
        main.goToView("view/homeWorkerView.fxml");
    }

}
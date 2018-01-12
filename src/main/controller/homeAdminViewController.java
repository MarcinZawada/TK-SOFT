package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.Main;//kadhsj

public class homeAdminViewController {
    private Main main;
    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.goToView("view/startView.fxml");
    }
    public void goWorker(ActionEvent event) throws Exception {
        main.goToView("view/homeWorkerView.fxml");
    }
    public void addEmployee(ActionEvent event) throws Exception {
        main.goToView("view/addEmployeeView.fxml");
    }
}
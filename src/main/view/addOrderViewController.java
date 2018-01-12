package main.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.Main;//kadhsj

public class addOrderViewController {
    private Main main;
    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.showStartView();
    }
    public void goBack(ActionEvent event) throws Exception {
        main.goHomeWorker();
    }
}

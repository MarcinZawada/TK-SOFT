package main.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import main.Main;//kadhsj

import java.awt.*;

public class startViewController {
    private Main main;

    @FXML
    private CheckBox isAdmin;

    @FXML
    public void logIn(ActionEvent event) throws Exception {
        if (isAdmin.isSelected()) {
            main.goHomeAdmin();
        } else {
            main.goHomeWorker();
        }
    }
}

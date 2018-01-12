package main.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import main.DbConnector;
import main.Main;//kadhsj

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addOrderViewController implements Initializable {
    private Main main;
    private DbConnector db;

    @FXML
    TextField product;

    @FXML
    TextField email;

    @FXML
    TextField count;

    @FXML
    TextArea details;

    @FXML
    Label error;

    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.goToView("view/startView.fxml");
    }
    public void goBack(ActionEvent event) throws Exception {
        main.goToView("view/homeWorkerView.fxml");
    }

    @FXML
    public void addOrder(ActionEvent event) throws Exception {
        if(email.getText().equals("")||product.getText().equals("")||count.getText().equals("")){
            error.setTextFill(Paint.valueOf("e41b1b"));
            error.setText("Please enter information");
            return;
        }

        Connection conn = db.connect();
        try {
            CallableStatement callableStatement = conn.prepareCall("{call addOrder(?,?,?,?)}");

            if(details.equals("")){
                callableStatement = conn.prepareCall("{call addClient(?,?,?,null)}");
            }else{
                callableStatement.setString(4, details.getText());
            }

            callableStatement.setString(1,product.getText());
            callableStatement.setString(2,email.getText());

            try{
                if(!count.getText().equals("")) {
                    callableStatement.setInt(3,Integer.parseInt(count.getText()));
                }
            }catch (NumberFormatException e){
                error.setTextFill(Paint.valueOf("e41b1b"));
                e.printStackTrace();
                return;
            }

            try {
                callableStatement.executeUpdate();
            }catch (SQLException e){
                error.setTextFill(Paint.valueOf("e41b1b"));
                error.setText(e.getMessage());
                return;
            }
            error.setTextFill(Paint.valueOf("#1de31b"));
            error.setText("order added");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DbConnector();
    }
}

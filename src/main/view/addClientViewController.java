package main.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import main.DbConnector;
import main.Main;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class addClientViewController implements Initializable {
    private Main main;
    private DbConnector db;

    @FXML
    TextField name;

    @FXML
    TextField surname;

    @FXML
    TextField mail;

    @FXML
    TextField number;

    @FXML
    Label error;

    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.goStartView();
    }
    public void goBack(ActionEvent event) throws Exception {
        main.goHomeWorker();
    }

    @FXML
    public void addClient(ActionEvent event) throws Exception {
        if(mail.getText().equals("")){
            error.setTextFill(Paint.valueOf("e41b1b"));
            error.setText("Email cannot be empty");
            return;
        }

        Connection conn = db.connect();
        try {
            CallableStatement callableStatement = conn.prepareCall("{call addClient(?,?,?,?)}");

            int num=0;
            try{
                if(!number.getText().equals("")) {
                    num = Integer.parseInt(number.getText());
                }
            }catch (Exception e){

            }

            if(num==0){
                callableStatement = conn.prepareCall("{call addClient(?,?,?,null)}");
            }else{
                callableStatement.setInt("Phone_number", num);
            }
            callableStatement.setString("Name",name.getText());
            callableStatement.setString("Surname",surname.getText());
            callableStatement.setString("Mail",mail.getText());

            callableStatement.executeUpdate();
            error.setTextFill(Paint.valueOf("#1de31b"));
            error.setText("client added");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DbConnector();
    }
}
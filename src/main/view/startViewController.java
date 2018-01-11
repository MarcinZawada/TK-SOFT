package main.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.DbConnector;
import main.Main;//kadhsj

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class startViewController implements Initializable{
    private Main main;
    private DbConnector db;
    private final String logErrorMsg = "";

    @FXML
    private CheckBox isAdmin;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;
    @FXML
    public void logIn(ActionEvent event) throws Exception {
        errorLabel.setText("");

        Connection conn = db.connect();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                                                "select * " +
                                                     "from `tk-soft`.passwords " +
                                                     "where Login=? and Password=?");
            preparedStatement.setString(1,login.getText());
            preparedStatement.setString(2,password.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                if (isAdmin.isSelected()) {
                    main.goHomeAdmin();
                } else {
                    main.goHomeWorker();
                }
            }
            else{
                errorLabel.setText("Bad login or password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db=new DbConnector();
    }

}

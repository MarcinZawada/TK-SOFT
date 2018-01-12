package main.view;


import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Client;
import main.DbConnector;
import main.Main;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class clientViewController implements Initializable{
    private Main main;
    private DbConnector db;

    @FXML
    private TableView<Client> clientsTable;
    @FXML
    TableColumn<Client,String> nameColumn;
    @FXML
    TableColumn<Client,String> surnameColumn;
    @FXML
    TableColumn<Client,String> emailColumn;
    @FXML
    TableColumn<Client,Integer> phoneColumn;

    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.showStartView();
    }
    public void clients(ActionEvent event) throws Exception {
        main.goClients();
    }
    public void orders(ActionEvent event) throws Exception {
        main.goOrders();
    }
    public void products(ActionEvent event) throws Exception {
        main.goProducts();
    }
    public void addClient(ActionEvent event) throws Exception {
        main.goAddClient();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DbConnector();
        ObservableList<Client> clients = FXCollections.observableArrayList();

        Connection conn = db.connect();

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(
                        "select * " +
                             "from clients ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            clients.add(new Client(resultSet.getString(1),
                                          resultSet.getString(2),
                                          resultSet.getString(3),
                                          resultSet.getInt(4)));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        nameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("surname"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Client, String>("mail"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Client, Integer>("number"));
        clientsTable.setItems(clients);

    }
}
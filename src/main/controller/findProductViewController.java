package main.controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.DbConnector;
import main.Main;//kadhsj
import main.Product;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class findProductViewController implements Initializable{
    private Main main;
    private DbConnector db;
    private String condition="";

    @FXML
    private TableView<Product> searchedProducts;

    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, String> poducentNameColumn;
    @FXML
    private TableColumn<Product, Integer> countColumn;
    @FXML
    private TableColumn<Product,Float> priceColumn;

    @FXML
    TextField nameText;
    @FXML
    TextField producentText;
    @FXML
    TextField priceText;

    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.goToView("view/startView.fxml");
    }
    @FXML
    public void goBack(ActionEvent event) throws Exception {
        main.goToView("view/homeWorkerView.fxml");
    }

    @FXML
    public void findProductsAction(ActionEvent event) throws Exception {
        condition = "";
        ObservableList<Product> searchedProductsArray = FXCollections.observableArrayList();
        Connection conn = db.connect();

        try {

            checkToCondition(nameText,"Name");
            checkToCondition(producentText,"Product_Name");
            checkToCondition(priceText,"Price");

            if(condition.equals("")){
                main.goToView("view/findProductView.fxml");
                return;
            }

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "select * " +
                            "from products where "+condition);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product client = new Product(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getFloat(4));
                searchedProductsArray.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        poducentNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("producentName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
        countColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("count"));


        searchedProducts.setItems(searchedProductsArray);

    }

    public void checkToCondition(TextField textField,String column){
        if(textField.getText().equals("")){
            return;
        }
        if(!Objects.equals(condition, "")){
            condition+=" and ";
        }
        if(column.equals("Name") || column.equals("Product_Name") ) {
            condition+=condition += column + " = \'" + textField.getText() + "\'";
        }
        else {
            condition += column + " = " + textField.getText();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DbConnector();
    }
}
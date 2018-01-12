package main.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import main.Main;//kadhsj

public class clientViewController {
    private Main main;
    @FXML
    public void logout(ActionEvent event) throws Exception {
        main.goStartView();
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
}
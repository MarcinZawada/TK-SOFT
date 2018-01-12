package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    private Stage primaryStage;
    private static BorderPane mainlayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("TK-Soft");
        showStartView();
    }


    public void showStartView() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/startView.fxml"));
        mainlayout=loader.load();
        Scene scene = new Scene(mainlayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void goHomeWorker() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/homeWorkerView.fxml"));
        BorderPane homeBorderPane = loader.load();
        mainlayout.setCenter(homeBorderPane);
    }

    public static void goHomeAdmin() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/homeAdminView.fxml"));
        BorderPane homeBorderPane = loader.load();
        mainlayout.setCenter(homeBorderPane);
    }
    public static void goStartView() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/startView.fxml"));
        BorderPane homeBorderPane = loader.load();
        mainlayout.setCenter(homeBorderPane);
    }
    public static void goClients() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/clientView.fxml"));
        BorderPane homeBorderPane = loader.load();
        mainlayout.setCenter(homeBorderPane);
    }
    public static void goOrders() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/orderView.fxml"));
        BorderPane homeBorderPane = loader.load();
        mainlayout.setCenter(homeBorderPane);
    }
    public static void goProducts() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/productView.fxml"));
        BorderPane homeBorderPane = loader.load();
        mainlayout.setCenter(homeBorderPane);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Application.launch(args);
        String username = "root";
        String password = "00000000";
        String conectionURL = "jdbc:mysql://localhost:3306";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(conectionURL, username, password);
            Statement statement = connection.createStatement()){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


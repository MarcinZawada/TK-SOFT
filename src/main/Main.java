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
    private String errorMsg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("TK-Soft");
        showStartView();
    }

    public void logIn(){

    }
    public void showStartView() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/startView.fxml"));
        mainlayout = loader.load();
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


    public static void main(String[] args) throws ClassNotFoundException {
        Application.launch(args);
        String username = "root";
        String password = "00000000";
        String conectionURL = "jdbc:mysql://localhost:3306";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = (DriverManager.getConnection(conectionURL, username, password));
           Statement statement = connection.createStatement()){
            /*    //statement.executeUpdate("");
                ResultSet resultSet = statement.executeQuery("Select * from lab3.ludzie");
               while(resultSet.next()){
                    System.out.println(resultSet.getInt(1));
                }

                PreparedStatement preparedStatement = connection.prepareStatement("select * from lab3.ludzie where PESEL = ?");*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


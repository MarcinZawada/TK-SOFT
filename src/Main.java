package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Hello World");
        showStartView();
    }

    public void showStartView() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        System.out.println(Main.class.getResource("view/startView.fxml"));
        /*loader.setLocation(getClass().getResource("view/startView.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }


    public static void main(String[] args) throws ClassNotFoundException {
        Application.launch(args);
        String username = "root";
        String password = "00000000";
        String conectionURL = "jdbc:mysql://localhost:3306";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(conectionURL, username, password);
            Statement statement = connection.createStatement()){
                //statement.executeUpdate("");
                ResultSet resultSet = statement.executeQuery("Select * from lab3.ludzie");
                while(resultSet.next()){
                    System.out.println(resultSet.getInt(1));
                }

                PreparedStatement preparedStatement = connection.prepareStatement("select * from lab3.ludzie where PESEL = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


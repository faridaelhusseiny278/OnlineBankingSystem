package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage stg;
    @FXML
    private Button RegisterButton, LoginButton;

    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Job Finder Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(700);
        primaryStage.setHeight(500);
        primaryStage.show();

        }
        @FXML
       public void registerFunction() throws IOException {
        Stage stage = (Stage) RegisterButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Register_FXML.fxml"));
        stage.setTitle("Poster HomeScreen");
        stage.setScene(new Scene(root));
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }
    @FXML
    public void loginFunction() throws IOException {
        Stage stage = (Stage) LoginButton.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("Login_FXML.fxml"));
        stage.setTitle("Poster HomeScreen");
        stage.setScene(new Scene(root));
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setResizable(true);
        stage.show();
    }


    public void changeScene(String fxml) throws IOException
        {
         Parent pane = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
         stg.getScene().setRoot(pane);
        }

    public static void main(String[] args) {
        launch();
    }
}
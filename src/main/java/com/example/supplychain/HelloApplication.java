package com.example.supplychain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private GridPane loginPage(){

        Label emailLabel = new Label("Email");
        Label passwordLable = new Label("Password");

        TextField emailTextField = new TextField();
        PasswordField passwordField = new PasswordField();

        GridPane gridPane = new GridPane();
        gridPane.add(emailLabel,0,0);
        gridPane.add(emailTextField,1,0);
        gridPane.add(passwordLable,0,1);
        gridPane.add(passwordField,1,1);

        return gridPane;
    }

    private Pane createContent(){
        Pane root = new Pane();

        root.getChildren().addAll(loginPage());
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
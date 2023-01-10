package com.example.premierprojetfx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addUser.fxml"));
        //Scene scene =new Scene(fxmlLoader.load(), 500, 240);
        // stage.setResizable(false);
        //stage.setScene(scene);
        //stage.show();
        Parent root = FXMLLoader.load(getClass().getResource("/addUser.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/CssStyle/AddUserStyle.css").toExternalForm());
        stage.show();




    }














    public static void main(String[] args) {
        launch();
    }
}
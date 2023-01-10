package com.example.premierprojetfx;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class mainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {


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
package com.example.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button oldUsersBtn;
    @FXML
    private Button newUsersBtn;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToNewUsersOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("newUsers.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Library App (New Users)");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }

    public void switchToOldUsersOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("oldUsers.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Library App (Old Users)");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}

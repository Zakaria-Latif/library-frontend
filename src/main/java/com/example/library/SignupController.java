package com.example.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void signupButtonOnAction(){
        System.out.println("Signup Btn Clicked!");
    }

    public void switchToLoginOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Library App (Login)");
        stage.setScene(scene);
        stage.show();
    }
}

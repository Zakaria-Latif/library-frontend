package com.example.library;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button loginButton;
    @FXML
    private Text loginAlerts;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSignupOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Library App (Signup)");
        stage.setScene(scene);
        stage.show();
    }

    public void loginButtonOnAction(ActionEvent e) {
        if (emailField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            System.out.println("event: " + e);
            System.out.println("email: " + emailField.getText() + " password: " + passwordField.getText());
            validateLogin();
        } else {
            loginAlerts.setText("dekhel email o password");
        }
    }

    public void validateLogin() {
        // TODO: Business Logic for Login
    }

}

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
import okhttp3.*;

import java.io.IOException;

public class SignupController {

    @FXML
    private Button signupButton;
    @FXML
    private Text signupAlerts;
    @FXML
    private TextField nameField;
    @FXML
    private TextField signupEmailField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private PasswordField signupPasswordField;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void signupButtonOnAction(ActionEvent event) throws IOException{

        System.out.println("Signup Btn Clicked!");
        if (signupEmailField.getText().isBlank() == false && signupPasswordField.getText().isBlank() == false && nameField.getText().isBlank() == false && confirmPasswordField.getText().isBlank() == false) {
            System.out.println("event: " + event);
//            System.out.println("email: " + emailField.getText() + " password: " + passwordField.getText());
            if (!signupPasswordField.getText().equals(confirmPasswordField.getText())){
                signupAlerts.setText("passwords do not match");
            }
            try {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, "{\r\n  \"name\":\"" + nameField.getText() +"\",\r\n  \"username\":\"" + signupEmailField.getText() +"\",\r\n  \"password\":\"" + signupPasswordField.getText() + "\"  \r\n}");
                Request request = new Request.Builder()
                        .url("http://localhost:8090/signup")
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .build();
                Response response = client.newCall(request).execute();

                System.out.println("response: "+response);

                if (response.code() == 200) {
                    root = FXMLLoader.load(getClass().getResource("home.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setTitle("Library App (Home)");
                    stage.setScene(scene);
                    stage.setMaximized(true);
                    stage.show();
                }
                if (response.code() == 400) {
                    signupAlerts.setText("something is incorrect");
                }
            }
            catch(Exception e) {
                System.out.println("signup error: "+e.getMessage());
            }

        } else {
            signupAlerts.setText("enter email and password and name and confirm password");
        }
    }

    public void switchToLoginOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Library App (Login)");
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();
    }
}

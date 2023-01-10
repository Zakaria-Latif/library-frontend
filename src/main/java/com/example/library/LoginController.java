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
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;




import okhttp3.*;

import com.google.gson.Gson;

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
        stage.setMaximized(true);
        stage.show();
    }

    public void loginButtonOnAction(ActionEvent event) throws IOException {
        if (emailField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
            System.out.println("event: " + event);
            System.out.println("email: " + emailField.getText() + " password: " + passwordField.getText());
            try {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, "{\r\n  \"username\":\"" + emailField.getText() +"\",\r\n  \"password\":\"" + passwordField.getText() + "\"  \r\n}");
                Request request = new Request.Builder()
                        .url("http://localhost:8090/login")
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
                     loginAlerts.setText("email or password is incorrect");
                 }
                 if (response.code() == 500) {
                     loginAlerts.setText("email not valid");
                 }
            }
            catch(Exception e) {
                System.out.println("Login error: "+e.getMessage());
            }

        } else {
            loginAlerts.setText("enter email and password");
        }

    }

}

package com.example.premierprojetfx.controllers;

import com.example.premierprojetfx.models.User;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddUserController {

    private Gson gson = new Gson();
    User currentUser;


    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField cin;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField email;
    @FXML
    private Label wrongSignup;
    @FXML
    private Button submit;
    byte a = 0;


    /*void testInputs(){

        if(name.getText().length()==0){
            wrongSignup.setText("Insert your name please!");
            a=1;
        }else {
            wrongSignup.setText("");
        }

        if( !valEmail(email.getText() )){
            wrongSignup.setText("Insert a valid e-mail please!");
            a=1;
        } else {
            wrongSignup.setText("");
        }

        if(phoneNumber.getText().length()<9){
            wrongSignup.setText("Insert a valid phone number please!");
            a=1;
        }else {
            wrongSignup.setText("");
        }

        if(cin.getText().length() ==0){
            wrongSignup.setText("Insert CIN");
            a=1;

        }else {
            wrongSignup.setText("");
        }

    }*/
    public static boolean valEmail(String input) {

        String emailReg = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

        Pattern emailPat = Pattern.compile(emailReg, Pattern.CASE_INSENSITIVE);

        Matcher matcher = emailPat.matcher(input);

        return matcher.find();
    }


    @FXML

    public void onClickButton(ActionEvent event) {


        currentUser = new User(FirstName.getText().toString(), LastName.getText().toString(), cin.getText().toString(), phoneNumber.getText().toString(), email.getText().toString());


        if (FirstName.getText().isBlank() || LastName.getText().isBlank() || cin.getText().isBlank() || phoneNumber.getText().isBlank() || email.getText().isBlank()) {
            wrongSignup.setText("All the fields must be filled");
        } else {
            if (phoneNumber.getText().length() != 10) {
                wrongSignup.setText("Phone number incorrect");
            } else {
                try {
                    float phone = Float.parseFloat(phoneNumber.getText());
                } catch (NumberFormatException e) {
                    wrongSignup.setText("10 digits interger please");
                }
            }

            if (!(valEmail(email.getText()))) {
                wrongSignup.setText("email not correct");

            }
        }


        String gsonString = gson.toJson(currentUser);
        addUser(gsonString);


        System.out.println(currentUser);
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("/userBooks.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage window = (Stage) submit.getScene().getWindow();
        window.setScene(new Scene(root));


    }

    public void addUser(String jsonString) {


        String urlPost = "http://localhost:8090/user";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlPost))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();

        try {
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());


            System.out.println(response.body());

            System.out.println("it workss");


        } catch (IOException | InterruptedException e) {

            e.printStackTrace();
        }


    }


}













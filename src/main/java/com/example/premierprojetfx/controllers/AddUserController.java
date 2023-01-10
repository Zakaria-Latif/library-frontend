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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddUserController {

    private Gson gson = new Gson();
    User currentUser ;


    @FXML
    private TextField id;
    @FXML
    private TextField name;
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
    byte a =0;





    void testInputs(){

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

    }
    public static boolean valEmail(String input){

        String emailReg = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

        Pattern emailPat = Pattern.compile(emailReg,Pattern.CASE_INSENSITIVE);

        Matcher matcher = emailPat.matcher(input);

        return matcher.find();
    }




        @FXML

        public void onClickButton(ActionEvent event){


            currentUser = new User(id.getText().toString(),name.getText().toString(),cin.getText().toString(),phoneNumber.getText().toString(),email.getText().toString()) ;


            System.out.println(gson.toJson(currentUser));
            Parent root ;

            try {
                root = FXMLLoader.load(getClass().getResource("/userBooks.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage window = (Stage) submit.getScene().getWindow();
            window.setScene(new Scene(root));


            }




}










package com.example.library;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;


public class addBookController {
    @FXML
    private StackPane rootPane;
    @FXML
    private TextField titleField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField ISBNField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField categoryField;
    @FXML
    private Text assignBookAlert;

    @FXML
    public void assignBookOnAction(ActionEvent event) throws MalformedURLException {
        if (titleField.getText().isBlank() || authorField.getText().isBlank() || ISBNField.getText().isBlank() || priceField.getText().isBlank() || categoryField.getText().isBlank()) {
            assignBookAlert.setText("All the Fields must be filled");
            System.out.println("All the Fields must be Filled");
        } else {
            if (ISBNField.getText().length() != 14) {
                assignBookAlert.setText("The ISBN Field must be 14 digits long");
                System.out.println("The ISBN Field must be 14 digits long");
            }
            else {
                try {
                    float prix = Float.parseFloat(priceField.getText());
                    //float input = Float.parseFloat(priceField.getText());
                    // Input is a valid float

                    System.out.println("event: " + event);
                    System.out.println("title: " + titleField.getText());
                    System.out.println("author: " + authorField.getText());
                    System.out.println("isbn: " + ISBNField.getText());
                    System.out.println("price: " + priceField.getText());
                    System.out.println("category: " + categoryField.getText());

                    Book1 book = new Book1(titleField.getText(), authorField.getText(), ISBNField.getText(), priceField.getText(), categoryField.getText());

                    Gson gson = new Gson();
                    String json = gson.toJson(book);

                    try {
                        URL url = new URL("http://localhost:8090/user/book");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.setRequestProperty("Content-Type", "application/json; utf-8");
                        con.setRequestProperty("Accept", "application/json");
                        con.setDoOutput(true);

                        try (OutputStream os = con.getOutputStream()) {
                            byte[] input = json.getBytes("utf-8");
                            os.write(input, 0, input.length);
                        }

                        int status = con.getResponseCode();
                        if (status == HttpURLConnection.HTTP_OK) {
                            // Successful request
                            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                            String inputLine;
                            StringBuffer response = new StringBuffer();
                            while ((inputLine = in.readLine()) != null) {
                                response.append(inputLine);
                            }
                            in.close();
                        } else {
                            // Error occurred
                            BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                            // Read the error response and log it
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } catch (NumberFormatException e) {
                    // Input is not a valid float
                    assignBookAlert.setText("The price must be a float value e.g. 85.00");
                    System.out.println("The price must be a float value e.g. 85.00");
                }
            }
        }
    }



    @FXML
    public void cancelOnAction(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}

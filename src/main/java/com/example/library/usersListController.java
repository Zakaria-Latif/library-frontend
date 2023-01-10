package com.example.library;
import com.example.library.User1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
class MyResponse {
    public List<User1> data;
}

public class usersListController implements Initializable {
    @FXML
    private TableView<User1> usersList;
    @FXML
    private TableColumn<User1, String> firstName, lastName, cin, phone, email;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private   Gson gson = new Gson();
    String url = "http://localhost:8090/user/ ";

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //PropertyValue factory should be exactly same as the LibraryUser from the class
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        //add data to the table here.
        usersList.setItems(LibraryUsersList);
    }

    ObservableList<User1> LibraryUsersList = FXCollections.observableArrayList(
            new User1("Ikrame","Jaa", "BE908683","0687859907","jaaikrame5@gmail.com"),
            new User1("Mohamed","Habit", "BE908683","0687859907","mohamedhabit@gmail.com"),
            new User1("Souad","Jamali", "BE908689","0687877707","souadjamali@gmail.com"),
            new User1("Salma","Hader", "BE908685","0687851111","salmahader@gmail.com"),
            new User1("Mouad","Noucer", "BE908322","0689843672","mouadnoucer@gmail.com")
    );


    public void getAllUsers() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            User1[] users = gson.fromJson(response.body(), User1[].class);
            for (User1 user : users) {
                LibraryUsersList.add(user);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void switchToHomePage (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Library App - Home");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBooks (ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("books.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Library App - Home");
        stage.setScene(scene);
        stage.show();
    }
}

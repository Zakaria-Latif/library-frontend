



package com.example.premierprojetfx.controllers;

import com.example.premierprojetfx.Book;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ResourceBundle;

public class UserBooksController implements Initializable {
        private Gson gson = new Gson();
        String url = "http://localhost:8080/Book/list ";

        @FXML
        public TableColumn<Book, String> bookCol;

        @FXML
        public TableView<Book> booksTable;

        @FXML
        public Button button;

        @FXML
        public TableColumn<Book, String> deletion;

        @FXML
        public Label userBooks;

        @FXML
        public void addBook(MouseEvent event) {

        }

        ObservableList<Book> list= FXCollections.observableArrayList(
                new Book("yes"),
                new Book("noo"),

                new Book("love")


        );
        /*public void loadData() {
                try{
                        Connection conn = dc.Connect();
                        ObservableList<UserDetails> data = FXCollections.observableArrayList();
                        ResultSet rs= conn.createStatement().executeQuery("SELECT * FROM member");
                        while(rs.next())
                                data.add(new UserDetails(rs.getInt("memberId"), rs.getString("fullName"), rs.getString("emailAddress"), rs.getString("DateOfBirth"), rs.getString("mailingAddress")));//RENAMED FROM "rs.getString(2),"
                        Tb1.setItems(data);// PLACED THIS UNDERNEATH "data.add" IT WASN'T BEFORE
                }catch(SQLException ex){
                        System.err.println("Error" + ex);
                }
        */

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(gson.toJson(userBooks)))
                .build();

        HttpResponse<String> response;


        {        try

        {
                response = client.send(request,
                        HttpResponse.BodyHandlers.ofString());
                Book[] books = gson.fromJson(response.body(), Book[].class);
                for (Book book : books) {

                        System.out.println(book.getBookName());
                }
        } catch(IOException e)

        {
                throw new RuntimeException(e);
        } catch(InterruptedException e)

        {
                throw new RuntimeException(e);
        }

}




        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
            bookCol.setCellValueFactory(new PropertyValueFactory<>("bookName"));

            booksTable.setItems(list);


        }



    }




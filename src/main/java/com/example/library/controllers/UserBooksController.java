



package com.example.library.controllers;

import com.example.library.Book;
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
        private   Gson gson = new Gson();
        String url = "http://localhost:8090/user/book ";


        @FXML
        public TableColumn<Book, String> title;
        @FXML
        public TableColumn<Book, String> author;
        @FXML
        public TableColumn<Book, String> isbn;
        @FXML
        public TableColumn<Book, String> price;
        @FXML
        public TableColumn<Book, String> category;
        @FXML
        public TableColumn<Book, String> borrower;

        @FXML
        public TableView<Book> booksTable;

        @FXML
        public Button button;

        @FXML
        public Label userBooks;

        @FXML
        public void addBook(MouseEvent event) {

        }

        ObservableList<Book> list= FXCollections.observableArrayList(
                new Book("the art of war","Sun tzu","9780140439199","81.55","Non-fiction","ikramejaa"),
                new Book("Invent and Wander","Jeff Bezzos","9781647820718","145.00","Autobiography","salmahader"),
                new Book("The Art of Computer Programming","Donald Knuth","9780201853926","259.00","Non-fiction","mouadnoucer"),
                new Book("Hunter X Hunter – Volume 36","Yoshihiro Togashi","9781974708413","85.00","Manga","souadjamali"),
                new Book("SPQR: A History of Ancient Rome","Mary Beard","9780871404237","150.89","History","zouhairghazal"),
                new Book("Harry Potter and the Philosopher's Stone","J. K. Rowling","9780439362139","75.98","FantasyFiction","karimaluna")





        );



        public void getAllBooks() {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("Content-Type", "application/json")
                        .build();
                HttpResponse<String> response;
                try {
                        response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        Book[] books = gson.fromJson(response.body(), Book[].class);
                        for (Book book : books) {
                                list.add(book);

                                System.out.println(book.getTitle());
                        }
                } catch (IOException e) {
                        throw new RuntimeException(e);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
        }

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
                //getAllBooks();





                title.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));

                author.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));

                isbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));

                price.setCellValueFactory(new PropertyValueFactory<>("price"));

                category.setCellValueFactory(new PropertyValueFactory<>("category"));

                borrower.setCellValueFactory(new PropertyValueFactory<>("borrower"));
                booksTable.setItems(list);







        }
    }




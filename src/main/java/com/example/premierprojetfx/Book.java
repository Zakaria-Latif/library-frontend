package com.example.premierprojetfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

public class Book {
    private SimpleStringProperty bookName;


    public Book(String bookName) {
        this.bookName = new SimpleStringProperty(bookName);
    }


    public String getBookName() {
        return bookName.get();
    }

    public void setBookName(String bookName) {
        this.bookName = new SimpleStringProperty(bookName);
    }
}

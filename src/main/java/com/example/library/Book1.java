package com.example.library;

public class Book1 {
    private String title;
    private String author;
    private String isbn;
    private String price;
    private String category;

    public Book1(String title, String author, String isbn, String price, String category){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        this.price=price;
        this.category=category;
    }
    public String getBookTitle() {
        return title;
    }
    public void setBookTitle(String title) {
        this.title = new String(title);
    }

    public String getBookAuthor() {
        return author;
    }
    public void setBookAuthor(String author) {
        this.author = new String(author);
    }

    public String getBookIsbn() {
        return isbn;
    }
    public void setBookIsbn(String isbn) {
        this.isbn = new String(isbn);
    }

    public String getBookPrice() {
        return price;
    }
    public void setBookPrice(String price) { this.price = new String (price);
    }

    public String getBookCategory() {
        return category;
    }
    public void setBookCategory(String category) {
        this.category = new String(category);
    }

    /*
    @Override
    public String toString() {
        return "Book{" +
                ", title=" + title +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
    */
}

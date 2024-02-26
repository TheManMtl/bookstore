package com.myBookstore.bookstore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;




@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "isbn is a required field.")
    @Size(max = 25, message = "isbn should not exceed 25 characters.")
    @Size(min = 10, message = "isbn must be at least 10 characters.")
    @Column(name = "isbn")
    private String isbn;

    @NotEmpty(message = "Title is a required field")
    @Size(max = 255, message = "Title should not exceed 255 characters")
    @Size(min = 4, message = "Title should be at least 4 characters long.")
    @Column(name = "title")
    private String title;
    @NotEmpty(message = "Author is a required field.")
    @Size(max = 255, message = "Author should not exceed 255 characters.")
    @Size(min = 4, message = "Author should be at least 4 characters long.")
    @Column(name = "author")
    private String author;
    @NotEmpty(message = "Publisher is a required field.")
    @Size(max = 255, message = "Publisher should not exceed 255 characters.")
    @Size(min = 5, message = "Publisher should be at least 5 characters long.")
    @Column(name = "publisher")
    private String publisher;
    @NotEmpty(message = "Description is a required field.")
    @Size(max = 1000, message = "Description should not exceed 1000 characters.")
    @Size(min = 10, message = "Description should be at least 10 characters long.")
    @Column(name = "description")
    private String description;
    @NotNull(message = "Price is a required field.")
    @DecimalMin(value = "0.01", message = "Price must be a non-negative number above 0.")
    @Column(name = "price")
    private double price;
    //double
    @NotNull(message = "Genre field cannot be empty")
    @Column(name = "genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Min(value = 0, message = "Inventory must be 0 or above")
    @NotNull(message = "Inventory is required")
    @Column(name = "inventory")
    private int inventory;
    @NotNull(message = "You must declare it available or unavailable.")
    @Column(name = "available")
    private boolean available;


    public Book() {
    }

    public Book(String isbn1, String s, String s1, String s2, String s3, double v, Genre genre, int i, boolean b) {
    }

    public Book(int id, String isbn, String title, String author, String publisher, String description, double price, Genre genre, int inventory, boolean available) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
        this.price = price;
        this.genre = genre;
        this.inventory = inventory;
        this.available = available;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", genre=" + genre +
                ", inventory=" + inventory +
                ", available=" + available +
                '}';
    }
}

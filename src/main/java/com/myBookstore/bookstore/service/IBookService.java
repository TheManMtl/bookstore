package com.myBookstore.bookstore.service;

import com.myBookstore.bookstore.entity.Book;
import com.myBookstore.bookstore.entity.Genre;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    List<Book> findAllByAvailable(boolean available);

    Optional<Book> findById(int theId);

    List<Book> findByGenre(Genre theGenre);

    void save(Book theBook);

    List<Book> findByGenreAndAvailable(Genre genre, boolean available);
    Optional<Book> findByIdAndAvailable(int id, boolean available);

    List<Book> findByPrice(double price);

    void updateInventory(Integer theId, int newBooksAmount);

    void updateAvailability(Integer theId, boolean available);

}

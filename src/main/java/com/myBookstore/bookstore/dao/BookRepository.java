package com.myBookstore.bookstore.dao;

import com.myBookstore.bookstore.entity.Book;
import com.myBookstore.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByGenre(Genre theGenre);
    List<Book> findAllByAvailable(Boolean available);
    List<Book> findByGenreAndAvailable(Genre genre, boolean available);
    Optional<Book> findByIdAndAvailable(int id, boolean available);

    List<Book> findByPrice(double price);

}





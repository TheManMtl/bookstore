package com.myBookstore.bookstore.service;

import com.myBookstore.bookstore.dao.BookRepository;
import com.myBookstore.bookstore.entity.Book;
import com.myBookstore.bookstore.entity.Genre;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements IBookService{

@Autowired
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository theBookRepository) {

        bookRepository = theBookRepository;
    }



    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findAllByAvailable(boolean available){

        return bookRepository.findAllByAvailable(available);
    }


    @Override
    public Optional<Book> findById(int theId) {
        return bookRepository.findById(theId);
    }

    @Override
    public List<Book> findByGenre(Genre theGenre) {
        return bookRepository.findByGenre(theGenre);
    }

    @Override
    public List<Book> findByGenreAndAvailable(Genre genre, boolean available){
        return bookRepository.findByGenreAndAvailable(genre, available);
    }
    @Override
    public Optional<Book> findByIdAndAvailable(int id, boolean available){
        return bookRepository.findByIdAndAvailable(id, available);
    }
    @Override
    public void save(Book theBook) {
        bookRepository.save(theBook);

    }



    @Override
    public List<Book> findByPrice(double price){
        return bookRepository.findByPrice(price);
    }

    @Override
    public void updateInventory(Integer theId, int newBooksAmount){
        Optional<Book> theBook = bookRepository.findById(theId);

        if (theBook.isPresent()) {
            Book book = theBook.get();
            int currentInventory = book.getInventory();
            book.setInventory(currentInventory + newBooksAmount);
            bookRepository.save(book);
            System.out.println("I am getting inside the book service");

            if (book.getInventory() <= 0) {
                updateAvailability(theId, false);
            }
        } else {
            throw new EntityNotFoundException("Book with ID " + theId + " is not found.");
        }
    }

    @Override
    public void updateAvailability(Integer theId, boolean available) {
        Optional<Book> theBook = bookRepository.findById(theId);
        if (theBook.isPresent()) {
            Book book = theBook.get();
            book.setAvailable(available);
            bookRepository.save(book);
        } else {
            throw new EntityNotFoundException("Book with ID " + theId + " is not found.");
        }
    }
}


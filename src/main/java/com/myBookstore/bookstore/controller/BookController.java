package com.myBookstore.bookstore.controller;


import com.myBookstore.bookstore.entity.Book;
import com.myBookstore.bookstore.entity.Genre;
import com.myBookstore.bookstore.service.IBookService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService iBookService;

    public BookController(IBookService theBookService) {
        iBookService = theBookService;
    }


    // TODO only available to admn and employee
    @GetMapping("/all")
    public String listAllBooks(Model theModel) {
        List<Book> theBooks = iBookService.findAll();
        theModel.addAttribute("books", theBooks);
        return "books";
    }


    @GetMapping("")
    public String listAllAvailable(Model theModel) {

        List<Book> theBooks = iBookService.findAllByAvailable(true);
        theModel.addAttribute("books", theBooks);
        return "books";
    }


    @GetMapping("/genre/all/{genre}")
    public String listByGenre(@PathVariable Genre genre, Model theModel) {
        List<Book> theBooks = iBookService.findByGenre(genre);
        theModel.addAttribute("books", theBooks);
        return "books";
    }


    @GetMapping("/genre/{genre}")
    public String listByGenreAvailable(@PathVariable Genre genre, Model theModel) {
        List<Book> theBooks = iBookService.findByGenreAndAvailable(genre, true);
        theModel.addAttribute("books", theBooks);
        return "books";
    }

    @GetMapping("/newAddPage")
    public String newAddPage(Model theModel) {
        Book theBook = new Book();
        theModel.addAttribute("theBook", theBook);
        return "addbook";
    }


    @PostMapping("/update")
    public String updateBook(@Validated @ModelAttribute("theBook") Book newBook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
           return "redirect:/books/all";

        }
        iBookService.save(newBook);
        return "redirect:/books/all";
    }

    @PostMapping("/save")
    public String saveBook(@Validated @ModelAttribute("theBook") Book newBook, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addbook";
        }
        iBookService.save(newBook);

        return "redirect:/books/all";

    }

    @PostMapping("/inventory-update")
    public String updateInventory(@Valid @ModelAttribute("theBook") Book theBook, BindingResult bindingResult) {
        int inventory = theBook.getInventory();
        int id = theBook.getId();
        System.out.println(id);
        if (bindingResult.hasErrors()) {
            return "redirect:/books/all";
        }
        iBookService.updateInventory(id, inventory);
        return "redirect:/books/all";

    }

}
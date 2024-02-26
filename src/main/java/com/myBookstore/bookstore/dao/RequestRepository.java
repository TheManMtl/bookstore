package com.myBookstore.bookstore.dao;


import com.myBookstore.bookstore.entity.Book;
import com.myBookstore.bookstore.entity.Genre;
import com.myBookstore.bookstore.entity.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RequestRepository extends JpaRepository<Requests, Integer> {

    List<Requests> findByStatus(String status);

    List<Requests> findByCustomerId(String customerId);

}

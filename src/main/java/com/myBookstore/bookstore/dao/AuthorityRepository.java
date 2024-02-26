package com.myBookstore.bookstore.dao;


import com.myBookstore.bookstore.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

}

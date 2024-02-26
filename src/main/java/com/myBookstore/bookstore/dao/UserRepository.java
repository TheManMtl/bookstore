package com.myBookstore.bookstore.dao;


import com.myBookstore.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

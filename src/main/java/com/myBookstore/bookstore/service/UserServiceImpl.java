package com.myBookstore.bookstore.service;

import com.myBookstore.bookstore.dao.UserRepository;
import com.myBookstore.bookstore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }

    @Override
    public void save(User theUser) {
        userRepository.save(theUser);
    }
}
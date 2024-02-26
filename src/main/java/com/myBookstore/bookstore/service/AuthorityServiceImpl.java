package com.myBookstore.bookstore.service;

import com.myBookstore.bookstore.dao.AuthorityRepository;
import com.myBookstore.bookstore.entity.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements IAuthorityService{

    @Autowired
    private final AuthorityRepository authorityRepository;

    public AuthorityServiceImpl(AuthorityRepository TheAuthorityRepository){

        authorityRepository = TheAuthorityRepository;
    }

    @Override
    public void save(Authority newAuth) {
        authorityRepository.save(newAuth);
    }
}
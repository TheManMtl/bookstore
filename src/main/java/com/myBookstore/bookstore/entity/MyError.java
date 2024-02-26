package com.myBookstore.bookstore.entity;

public class MyError {
    public String message;
    public boolean isError;

    public MyError(String message, boolean isError) {
        this.message = message;
        this.isError = isError;
    }


}

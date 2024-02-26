package com.myBookstore.bookstore.entity;

import java.math.BigDecimal;
import java.util.Date;

public class RequestViewDto {
    private int id;
    private int bookId;
    private String customerId;
    private String employeeId;
    private Date requestDate;
    private Date updateDate;
    private String status;
    private String bookTitle;
    private String bookAuthor;
    private BigDecimal bookPrice;
    private int bookInventory;

    public RequestViewDto() {
    }

    public RequestViewDto(int id, int bookId, String customerId, String employeeId, Date requestDate, Date updateDate, String status, String bookTitle, String bookAuthor, BigDecimal bookPrice, int bookInventory) {
        this.id = id;
        this.bookId = bookId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.requestDate = requestDate;
        this.updateDate = updateDate;
        this.status = status;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookInventory = bookInventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(int bookInventory) {
        this.bookInventory = bookInventory;
    }
}


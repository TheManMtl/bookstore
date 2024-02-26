package com.myBookstore.bookstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;


@Entity
@Table(name = "requests")
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Book ID cannot be empty")
    @Column(name = "book_id")
    private int bookId;

    @NotNull(message = "Customer ID cannot be empty")
    @Size(max = 50, message = "Customer ID must not exceed 50 character")
    @Column(name = "customer_id")
    private String customerId;


    @Size(max = 50, message = "Employee ID must not exceed 50 character")
    @Column(name = "employee_id")
    private String employeeId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Request date cannot be empty")
    @Column(name = "request_date")
    private Date requestDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "status_update_date")
    private Date updateDate;

    @Pattern(regexp = "^(REQUEST|CANCELLED|FULFILLED)$", message = "Status should be REQUEST, CANCELLED, or FULFILLED")
    @NotEmpty(message = "Status must be either request, cancel, or fulfill")
    @Column(name = "status")
    private String status;

    public Requests() {
    }

    public Requests(int id, int bookId, String customerId, String employeeId, Date requestDate, Date updateDate, String status) {
        this.id = id;
        this.bookId = bookId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.requestDate = requestDate;
        this.updateDate = updateDate;
        this.status = status;
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

    @Override
    public String toString() {
        return "Requests{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", customerId='" + customerId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", requestDate=" + requestDate +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                '}';
    }
}

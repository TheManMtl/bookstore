package com.myBookstore.bookstore.service;

import com.myBookstore.bookstore.entity.Book;
import com.myBookstore.bookstore.entity.RequestViewDto;
import com.myBookstore.bookstore.entity.Requests;


import java.util.List;
import java.util.Optional;

public interface IRequestService {

    Optional<Requests> findById(int theId);

    void save(Requests theRequest);

//    List<Object[]> findByStatus(String status);
//
//    List<Object[]> findByCustomerIdAndStatus(String customerId, String status);
//
//    List<Object[]> findByCustomerId(String customerId);
//
    List<Requests> findAll();


    void processRequest(int requestId, String employeeId, String status);

    void cancelRequest(int requestId);

    List<RequestViewDto> getAllRequestsWithBookDetails();

    List<Requests> findByCustomerId(String customerId);

    List<RequestViewDto> getRequestsWithBookDetailsByCustomerId(String customerId);

    List<Requests> findByStatus(String status);

    List<RequestViewDto> findAllByStatus(String status);
}

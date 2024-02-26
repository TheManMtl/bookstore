package com.myBookstore.bookstore.service;

import com.myBookstore.bookstore.dao.RequestRepository;
import com.myBookstore.bookstore.entity.Book;
import com.myBookstore.bookstore.entity.RequestViewDto;
import com.myBookstore.bookstore.entity.Requests;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class RequestServiceImpl implements IRequestService {
    @Autowired
    private final RequestRepository requestRepository;
    private final IBookService iBookService;


    public RequestServiceImpl(RequestRepository theRequestRepository, IBookService theBookService) {

        requestRepository = theRequestRepository;
        iBookService = theBookService;
    }

    @Override
    public void save(Requests theRequest) {
    requestRepository.save(theRequest);
    }

    @Override
    public List<Requests> findAll() {
      return  requestRepository.findAll();
    }


    @Override
    public Optional<Requests> findById(int theId) {
        return requestRepository.findById(theId);
    }

//    @Override
//    public List<Object[]> findByStatus(String status) {
//        return requestRepository.findByStatus(status);
//    }
//
//    @Override
//    public List<Object[]> findByCustomerIdAndStatus(String customerId, String status) {
//        return requestRepository.findByCustomerIdAndStatus(customerId, status);
//    }
//
//    @Override
//    public List<Object[]> findByCustomerId(String customerId) {
//        return requestRepository.findByCustomerId(customerId);
//    }
//




    @Override
    public void processRequest(int requestId, String employeeId, String status){
        Optional<Requests> theRequest = requestRepository.findById(requestId);
        if (theRequest.isPresent()) {
            Requests request = theRequest.get();
            request.setEmployeeId(employeeId);
            request.setStatus(status);
            request.setUpdateDate(new Date());
            requestRepository.save(request);
            System.out.println(request.getBookId() + " this is my book id");

            if (Objects.equals(status, "FULFILLED")) {
                iBookService.updateInventory(request.getBookId(), -1);
            }

        } else {
            throw new EntityNotFoundException("Book with ID " + requestId + " is not found.");
        }
    }

    @Override
    public void cancelRequest(int requestId){
        Optional<Requests> theRequest = requestRepository.findById(requestId);
        if (theRequest.isPresent()) {
            Requests request = theRequest.get();
            request.setStatus("CANCELLED");
            request.setUpdateDate(new Date());
            requestRepository.save(request);


        } else {
            throw new EntityNotFoundException("Book with ID " + requestId + " is not found.");
        }
    }

    @Override
    public List<RequestViewDto> getAllRequestsWithBookDetails() {
        List<Requests> requestsList = requestRepository.findAll();
        List<RequestViewDto> requestViewDtoList = new ArrayList<>();

        for (Requests request : requestsList) {
            RequestViewDto requestViewDto = new RequestViewDto();

            requestViewDto.setId(request.getId());
            requestViewDto.setBookId(request.getBookId());
            requestViewDto.setCustomerId(request.getCustomerId());
            requestViewDto.setEmployeeId(request.getEmployeeId());
            requestViewDto.setRequestDate(request.getRequestDate());
            requestViewDto.setUpdateDate(request.getUpdateDate());
            requestViewDto.setStatus(request.getStatus());

            Optional<Book> optionalBook = iBookService.findById(request.getBookId());

            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                requestViewDto.setBookTitle(book.getTitle());
                requestViewDto.setBookAuthor(book.getAuthor());
                requestViewDto.setBookPrice(BigDecimal.valueOf(book.getPrice()));
                requestViewDto.setBookInventory(book.getInventory());
            }

            requestViewDtoList.add(requestViewDto);
        }

        return requestViewDtoList;
    }


    public List<Requests> findByCustomerId(String customerId){
        return requestRepository.findByCustomerId(customerId);
    }

    @Override
    public List<RequestViewDto> getRequestsWithBookDetailsByCustomerId(String customerId) {
        List<Requests> requestsList = requestRepository.findByCustomerId(customerId);
        List<RequestViewDto> requestViewDtoList = new ArrayList<>();

        for (Requests request : requestsList) {
            RequestViewDto requestViewDto = new RequestViewDto();

            requestViewDto.setId(request.getId());
            requestViewDto.setBookId(request.getBookId());
            requestViewDto.setCustomerId(request.getCustomerId());
            requestViewDto.setEmployeeId(request.getEmployeeId());
            requestViewDto.setRequestDate(request.getRequestDate());
            requestViewDto.setUpdateDate(request.getUpdateDate());
            requestViewDto.setStatus(request.getStatus());

            Optional<Book> optionalBook = iBookService.findById(request.getBookId());

            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                requestViewDto.setBookTitle(book.getTitle());
                requestViewDto.setBookAuthor(book.getAuthor());
                requestViewDto.setBookPrice(BigDecimal.valueOf(book.getPrice()));
                requestViewDto.setBookInventory(book.getInventory());
            }

            requestViewDtoList.add(requestViewDto);
        }

        return requestViewDtoList;
    }

    public List<Requests> findByStatus(String status){
        return requestRepository.findByStatus(status);
    }

    public List<RequestViewDto> findAllByStatus(String status){
        List<Requests> requestsList = requestRepository.findByStatus(status);
        List<RequestViewDto> requestViewDtoList = new ArrayList<>();

        for (Requests request : requestsList) {
            RequestViewDto requestViewDto = new RequestViewDto();

            requestViewDto.setId(request.getId());
            requestViewDto.setBookId(request.getBookId());
            requestViewDto.setCustomerId(request.getCustomerId());
            requestViewDto.setEmployeeId(request.getEmployeeId());
            requestViewDto.setRequestDate(request.getRequestDate());
            requestViewDto.setUpdateDate(request.getUpdateDate());
            requestViewDto.setStatus(request.getStatus());

            Optional<Book> optionalBook = iBookService.findById(request.getBookId());

            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                requestViewDto.setBookTitle(book.getTitle());
                requestViewDto.setBookAuthor(book.getAuthor());
                requestViewDto.setBookPrice(BigDecimal.valueOf(book.getPrice()));
                requestViewDto.setBookInventory(book.getInventory());
            }

            requestViewDtoList.add(requestViewDto);
        }

        return requestViewDtoList;

    }
}

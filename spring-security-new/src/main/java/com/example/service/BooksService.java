package com.example.service;

import com.example.dto.Books;
import com.example.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//defining the business logic
@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

    //getting all books record by using the method findaAll() of CrudRepository
    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<Books>();
        booksRepository.findAll().forEach(books1 -> books.add(books1));
        return books;
    }

    //getting a specific record by using the method findById() of CrudRepository
    public Books getBooksById(int id) {
        return booksRepository.findById(id).get();
    }

    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Books books) {
        booksRepository.save(books);
    }

    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    //updating a record
    public void update(Books books, int bookid) {
        Optional<Books> byId = booksRepository.findById(bookid);
        if (!byId.isPresent()){
            return;
        }
        Books books1 = byId.get();
        books1.setBookid(bookid);
        books1.setBookname(books.getBookname());
        books1.setPrice(books.getPrice());
        books1.setAuthor(books.getAuthor());
        booksRepository.save(books1);
    }
}
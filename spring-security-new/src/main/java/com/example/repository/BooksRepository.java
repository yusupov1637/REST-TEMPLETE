package com.example.repository;

import com.example.dto.Books;
import org.springframework.data.repository.CrudRepository;


public interface BooksRepository extends CrudRepository<Books, Integer>
{
}

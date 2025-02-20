package com.example.findbook;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    @Query("{'isbn': ?0}")
    List<Book> findByIsbn(String isbn);
}



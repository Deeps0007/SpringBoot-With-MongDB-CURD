package com.example.model;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepositry extends MongoRepository<Book, Integer>{

}

package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.model.BookRepositry;

@RestController
public class BookController {

	@Autowired
	private BookRepositry repo;
	
	
	@GetMapping("/")
	public Book info()
	{
		return new Book();
	}
	
	
	@PostMapping("/save")
	public String saveBook(@RequestBody Book book)
	{
		repo.save(book);
		return "Added Book with ID :";
	}
	
	@GetMapping("/getBooks")
	public List<Book> getBooks()
	{
		return repo.findAll();
	}
	
	@GetMapping("/findBook/{id}")
	public Optional<Book> getBook(@PathVariable int id)
	{
		return repo.findById(id);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id)
	{
		 repo.deleteById(id);
		 return "book deleted";
	}
	
}

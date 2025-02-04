package com.sathya.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/message")
	public String getMessage()
	{
		return "Good Morning Deepika";
	}
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable String name)
	{
		return "Hello "+name;
	}
	
	List<Book> books = List.of(new Book(111,"Java","Ratan",980),
								new Book(222,"Spring","Ratan",450),
								new Book(333,"SpringBoot","Ratan",760),
								new Book(444,"ReactJS","Narasimha",675),
								new Book(555,"OOPS","Kannababu",910));
	
	@GetMapping("/booklist")
	public List<Book> getBooks()
	{
		return books;
	}
	
	@GetMapping("/getbook/{isbn}")
	public Book getBook(@PathVariable int isbn)
	{
		Book book = books.stream().filter(book1 -> book1.getIsbn() ==isbn).findFirst().get();
		return book;
	}
}

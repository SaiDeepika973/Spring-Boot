package com.sathya.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sathya.orm.repository.BookRepository;
@Component
public class BookClient implements CommandLineRunner{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		//to get author and isbn
		List<String> authors = bookRepository.getData();
		authors.forEach(author->System.out.println(author));
		
		//to get the author count
		int authorCount = bookRepository.authorCount("ratan");
		System.out.println(authorCount);
		
		//to get distinct authors
		List<String> distinctAuthors = bookRepository.authorDistinct();
		distinctAuthors.forEach(author1->System.out.println(author1));
		
		
	}

}

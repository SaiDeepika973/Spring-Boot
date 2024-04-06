package com.sathya.orm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sathya.orm.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

	@Query("SELECT b.isbn,b.author from Book b")
	public List<String> getData();
	
	@Query("SELECT COUNT(b) FROM Book b WHERE b.author = :author")
	public int authorCount(String author);
	
	@Query("SELECT DISTINCT b.author FROM Book b")
	public List<String> authorDistinct();
}

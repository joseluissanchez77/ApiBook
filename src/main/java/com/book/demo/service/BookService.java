package com.book.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.demo.model.Book;
import com.book.demo.repository.IBookRepository;


@Service
public class BookService {

	@Autowired
	private IBookRepository bookRepository;
	
	public List<Book> listBook(){
		return bookRepository.findAll();
	}
	
	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
	public Book getByIdBook(Integer id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}
	
}

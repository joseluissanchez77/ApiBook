package com.book.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.demo.model.Book;
import com.book.demo.service.BookService;


@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public List<Book> listarLibros(){
		return bookService.listBook();
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> obtenerLibroPorId(@PathVariable Integer id) {
		try {
			Book book = bookService.getByIdBook(id);
			
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/book")
	public void guardarLibro(@RequestBody Book book) {
		bookService.saveBook(book);
	}
	
	@PutMapping("/book/id")
	public ResponseEntity<?> actualizarLibro(@RequestBody Book book, @PathVariable Integer id){
		try {
			Book bookExist = bookService.getByIdBook(id);
			bookService.saveBook(bookExist);
			return new ResponseEntity<Book>( HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/book/id")
	public void eliminarLibro(@PathVariable Integer id) {
		bookService.deleteBook(id);
	}
}

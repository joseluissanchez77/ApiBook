package com.book.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.demo.model.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {

}

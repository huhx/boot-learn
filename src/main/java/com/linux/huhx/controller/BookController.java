package com.linux.huhx.controller;

import com.linux.huhx.exception.BaseRuntimeException;
import com.linux.huhx.model.Book;
import com.linux.huhx.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookRepository bookRepository;

  @GetMapping
  public Iterable findAll() {
    return bookRepository.findAll();
  }

  @GetMapping("/title/{bookTitle}")
  public List<Book> findByTitle(@PathVariable String bookTitle) {
    return bookRepository.findByTitle(bookTitle);
  }

  @GetMapping("/{id}")
  public Book findOne(@PathVariable Long id) {
    return bookRepository.findById(id)
        .orElseThrow(() -> new BaseRuntimeException("Book Not Found."));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Book create(@RequestBody Book book) {
    return bookRepository.save(book);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    bookRepository.findById(id).orElseThrow(() -> new BaseRuntimeException("Book Not Found."));
    bookRepository.deleteById(id);
  }

  @PutMapping("/{id}")
  public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
    if (book.getId() != id) {
      throw new BaseRuntimeException("Not match book id.");
    }
    bookRepository.findById(id).orElseThrow(() -> new BaseRuntimeException("Book Not Found."));
    return bookRepository.save(book);
  }
}


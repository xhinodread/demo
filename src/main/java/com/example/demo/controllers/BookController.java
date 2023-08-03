package com.example.demo.controllers;

import com.example.demo.exceptions.BookIdMismatchException;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.persistence.model.Book;
import com.example.demo.persistence.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@RestController
@RequestMapping("/api/books")
public class BookController {
   // @Qualifier("datasource1")

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
        Iterable books = bookRepository.findAll();
        System.out.println("losBook : "+books );

       if(!false) {
           if (books instanceof Collection) {
               System.out.println("losBook : " + ((Collection<?>) books).size());
               if (((Collection<?>) books).size() == 0) {
                   bookRepository.save(bookRepository.libros.get(0));
                   books = bookRepository.findAll();
               }
           }
       }
        return books;
    }
    @GetMapping("/title/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle) {
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    @PostMapping(path="/agregar_book")
    public ResponseEntity<Book> createBook(@ModelAttribute Book book)  {
        System.out.println("from json input : "+book );
        try {
            bookRepository.save(book);
            // return "book";
            //return ResponseEntity.ok(book);
            /******
             URI location = ServletUriComponentsBuilder
             .fromCurrentRequest()
             .path("/../{id}")
             .buildAndExpand(book.getId())
             .toUri();
             System.out.println("location resonse : "+location );
             return ResponseEntity.created(location).build();
             *******/
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/books")).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/books")).build();
        }

    }

    @GetMapping("/new/{nombre}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createRandomBookX(@PathVariable String nombre) {
        Book book = new Book();
        book.setTitle(nombre);
        book.setAuthor("Jp");
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        System.out.println("from json book : "+ book );

        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }

    @PostMapping("/edit_book")
    public ResponseEntity<Void> updateElBook(@ModelAttribute Book book) {
    //public Book updateElBook(@ModelAttribute Book book, @PathVariable Long id) {
       // System.out.println("from ResponseEntity book : "+ book );
        if (book == null) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(book.getId())
                .orElseThrow(BookNotFoundException::new);
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/books")).build();
    }



}




// @RequestMapping(value = "/agregar_book", method = RequestMethod.POST)
/****
 @PostMapping(
 value="/agregar_book",
 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
 )
 @ResponseStatus(HttpStatus.CREATED)
 @RequestMapping(value = "/agregar_book", method = RequestMethod.POST)
 public String createBook(@RequestBody(required = false) Book book) {
 public String createBook(@RequestBody String book)  {
 ***/
//@RequestMapping(method = RequestMethod.POST, value = "/agregar_book", headers = "accept=application/json")

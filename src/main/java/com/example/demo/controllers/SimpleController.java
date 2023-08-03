package com.example.demo.controllers;

import com.example.demo.persistence.model.Book;
import com.example.demo.persistence.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class SimpleController {
    @Autowired
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }


    @GetMapping("/nuevo_book")
    public String nuevoBook(Book book){
        return "nuevo_libro";
    }

    @GetMapping("/books")
    public String listAll(ModelMap mp) {
        Iterable<Book> books = bookRepository.findAll();
        System.out.println("from json input : "+books );
        mp.put("books", books );
        return "libros";
    }

    @GetMapping("/edit_book/{id}")
    public String editBook(ModelMap mp, @PathVariable("id") Long id){
        Optional<Book> elBook =bookRepository.findById(id);
        System.out.println("from json input : "+ elBook );
        mp.put("book", elBook );
        return "editar_libro";
    }
}

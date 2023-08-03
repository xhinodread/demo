package com.example.demo.persistence.repo;

import com.example.demo.persistence.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    ArrayList<Book> libros = new ArrayList<>(
            List.of(
                    new Book( "libri uno", "chileregion"),
                    new Book("libri dos", "chileregion"),
                    new Book("libri tres", "chileregion")
            )
    );

    List<Book> findByTitle(String title);
}

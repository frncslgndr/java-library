package com.orobas.librairie.Graphql;

import com.orobas.librairie.Entity.Book;
import com.orobas.librairie.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.management.InstanceNotFoundException;

@Controller
public class BookControllerQL {
    @Autowired
    private BookService bookService;

    @QueryMapping
    public Iterable<Book> books() {
        return this.bookService.findAllBooks();
    }

    @QueryMapping
    public Book bookById(Integer id) throws InstanceNotFoundException {
        return this.bookService.findBookById(id);
    }
}

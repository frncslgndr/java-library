package com.orobas.librairie.Controller;

import com.orobas.librairie.Entity.Book;
import com.orobas.librairie.Service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {
    // Défini une dépendance BookSqlService
    private BookService bookService;

    // Injection de dépendances via constructor
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //CREATE
    //Ajouter un livre
    @PostMapping("/create/book")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    //READ
    //Récupérer tous les livres
    @GetMapping("/read/all")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    //Récuperer un seul livre
    @GetMapping("/read/{id}")
    public Book findBookById(@PathVariable("id") Integer id) throws InstanceNotFoundException {
        return bookService.findBookById(id);
    }

    //UPDATE
    //pas vraiment adapté à l'architecture actuelle

    //DELETE
    //Supprimer un livre
    @DeleteMapping("/delete/{id}")
    private void deleteBookById(@PathVariable("id") Integer id) throws InstanceNotFoundException {
        bookService.delete(id);
    }

}

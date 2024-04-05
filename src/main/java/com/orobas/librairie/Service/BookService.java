package com.orobas.librairie.Service;

import com.orobas.librairie.Entity.Book;
import com.orobas.librairie.Repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //Fonction pour récupérer tous les livres
    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    //Fonctions pour récupérer 1 livre via son ID
    public Book findBookById(Integer id) throws InstanceNotFoundException {
        return this.bookRepository.findById(id).orElseThrow(InstanceNotFoundException::new);
    }

    //Fonction pour ajouter un livre
    public Book addBook(Book book)  {
        return this.bookRepository.save(book);
    }

    //Fonction pour supprimer un livre
    public void delete(Integer id) throws InstanceNotFoundException{
        this.bookRepository.deleteById(id);
    }

}

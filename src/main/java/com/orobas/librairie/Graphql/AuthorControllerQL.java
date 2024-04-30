package com.orobas.librairie.Graphql;

import com.orobas.librairie.Entity.Author;
import com.orobas.librairie.Repository.AuthorRepository;
import com.orobas.librairie.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.management.InstanceNotFoundException;

@Controller
public class AuthorControllerQL {
    @Autowired
    private AuthorService authorService;

    private AuthorRepository authorRepository;

    @QueryMapping
    public Iterable<Author> authors() {
        return this.authorService.findAll();
    }

    @QueryMapping
    public Author authorById(Integer id) throws InstanceNotFoundException {
        return this.authorRepository.findById(id).orElseThrow(InstanceNotFoundException::new);
    }
}

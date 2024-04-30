package com.orobas.librairie.Service;

import com.orobas.librairie.Entity.Author;
import com.orobas.librairie.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}

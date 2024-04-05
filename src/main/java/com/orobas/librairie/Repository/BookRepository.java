package com.orobas.librairie.Repository;

import com.orobas.librairie.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}